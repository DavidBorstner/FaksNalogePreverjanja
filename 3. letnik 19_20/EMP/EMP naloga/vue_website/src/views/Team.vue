<template>
    <b-container>
        <div v-if="ekipa && trener && dvorana">
            <b-row class="my-3">
                <b-col>
                    <h1>{{ ekipa.naziv }}</h1>
                </b-col>
            </b-row>
            <b-row align-v="center">
                <b-col xs="6" md="2">
                    <b-img style="width: 100%" :src="ekipa.logo" ></b-img>
                </b-col>
                <b-col>
                    <b>Dvorana:</b> {{ dvorana.naziv }}<br>
                    <b>Trener:</b> {{ trener.ime + ' ' + trener.priimek }}<br>
                </b-col>
                <b-col>
                    <h3 class="mb-3">Tekme</h3>
                    <b-table :fields="tekmeFields" :items="tekme">
                        <template v-slot:cell(nasprotnik)="row">
                            {{ (row.item.ekipa1 === $route.params.id ? getEkipa(row.item.ekipa2) : getEkipa(row.item.ekipa1) ) }}
                        </template>
                        <template v-slot:cell(zapisnik)="row">
                            <b-btn :to="'/zapisniki/'+row.item.id" variant="success">{{ ( allowEdit ? 'Zapisnik' : 'Rezultati' ) }}</b-btn>
                        </template>
                        <template v-slot:cell(rezultat)="row">
                            {{ row.item.tocke1 }}:{{ row.item.tocke2 }}
                        </template>
                        <template v-slot:cell(stevilka)="row">
                            {{ row.item.tocke1 }}:{{ row.item.tocke2 }}
                        </template>
                    </b-table>
                </b-col>
            </b-row>
            <b-row>
                <b-col>
                    <h3 class="mb-3">Seznam igralcev:</h3>
                    <b-table selectable
                             select-mode="single"
                             selectedVariant="success"
                             @row-selected="igralecSelected" :fields="igralciFields" :items="igralci">
                        <template v-slot:cell(igralec)="row">
                            {{ row.item.ime + ' ' + row.item.priimek }}
                        </template>
                        <template v-slot:cell(profilka)="row">
                            <b-img height="30" :src="row.item.slika"></b-img>
                        </template>
                        <template v-slot:cell(visina)="row">
                            {{ row.item.visina + " cm"}}
                        </template>
                        <template v-slot:cell(teza)="row">
                            {{ row.item.teza + " kg"}}
                        </template>
                        <template v-slot:cell(pozicija)="row">
                            {{ getPozicija(row.item.pozicija) }}
                        </template>
                        <template v-slot:cell(stevilka)="row">
                            {{ row.index+1 }}
                        </template>
                    </b-table>
                </b-col>
            </b-row>
        </div>
    </b-container>
</template>

<script>
  import {db} from '@/firebaseConfig.js'
  import firebase from 'firebase'

  export default {
    name: "Team",
    data: function () {
      return {
        ekipa: null,
        trener: null,
        dvorana: null,
        pozicija: {
          pozicija: null
        },
        igralci: [],
        tekme: [],
        igralciFields: [
          {key: 'stevilka', label: 'Številka'},
          {key: 'igralec', label: 'Ime in priimek'},
          {key: 'profilka', label: ''},
          {key: 'visina', label: 'Višina'},
          {key: 'teza', label: 'Teža'},
          {key: 'pozicija', label: 'Igralna pozicija'}
        ],
        tekmeFields: [
          {key: 'nasprotnik', label: 'Nasprotnik'},
          {key: 'rezultat', label: 'Rezultat'},
          {key: 'zapisnik', label: 'Zapisnik'}
        ],
        ekipe: [],
        pozicije: []
      }
    },
    methods: {
      getTekme() {
        db.collection('tekme').where('ekipa1', '==', this.$route.params.id).get()
          .then(snap => {
            snap.forEach(doc => {
              this.tekme.push(Object.assign({}, doc.data(), { id: doc.id }))
            })
          })
        db.collection('tekme').where('ekipa2', '==', this.$route.params.id).get()
          .then(snap => {
            snap.forEach(doc => {
              this.tekme.push(Object.assign({}, doc.data(), { id: doc.id }))
            })
          })
      },
      getPozicija(id){
        return this.pozicije.find(poz => poz.id === id).pozicija
      }, 
      getEkipa(id) {
        return this.ekipe.filter(el => el.id === id)[0].naziv
      },
      igralecSelected(items){
        this.$router.push('/igralci/'+items[0].id)
      }
    },
    firestore() {
      return {
        ekipa: db.collection('ekipe').doc(this.$route.params.id),
        ekipe: db.collection('ekipe'),
        pozicije: db.collection('pozicija')
      }
    },
    watch: {
      ekipa(ekipa) {
        if (ekipa.naziv) {
          this.$bind('trener', db.collection('trener').doc(ekipa.trener))
          this.$bind('dvorana', db.collection('dvorane').doc(ekipa.dvorana))
          this.$bind('igralci', db.collection('igralci').where('ekipa', '==', this.$route.params.id))
          this.getTekme()
        }
      }
    },
    computed: {
      allowEdit(){
        if(firebase.auth().currentUser){
          return firebase.auth().currentUser.email === 'neki@neki.com'
        }
        return false
      }
    }
  }
</script>

<style scoped>

</style>
