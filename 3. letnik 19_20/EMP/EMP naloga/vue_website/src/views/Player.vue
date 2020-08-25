<template>
    <b-container>
        <b-row class="my-3">
            <b-col>
                <h1>{{ igralec.ime }} {{ igralec.priimek }}</h1>
            </b-col>
        </b-row>
        <b-row align-v="center">
            <b-col xs="6" md="3" lg="2">
                <b-img :src="igralec.slika"></b-img>
            </b-col>
            <b-col v-if="ekipa && igralec && pozicija" class="ml-5">
                <b>Pozicija</b>: {{ pozicija.pozicija }} <br>
                <b>Ekipa</b>: {{ ekipa.naziv }} <br>
                <b>Teža</b>: {{ igralec.teza }} <br>
                <b>Višina</b>: {{ igralec.visina }}
            </b-col>
        </b-row>
        <b-row class="my-3">
            <b-col>
                <h3>Zadnje tekme</h3>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-table selectable
                         select-mode="single"
                         selectedVariant="success"
                         @row-selected="nastopSelected"
                         :items="nastopi"
                         :fields="tekmeFields">
                    <template v-if="igralec" v-slot:cell(proti)="row">
                        {{ findNasprotnaEkipa(row.item) }}
                    </template>
                    <template v-slot:cell(rezultat)="row">
                        {{ findRezultatTekme(row.item) }}
                    </template>
                </b-table>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>
  import {db} from '@/firebaseConfig.js'

  export default {
    name: "Player",
    data: function () {
      return {
        igralec: {},
        pozicija: {
          pozicija: null
        },
        ekipa: null,
        nastopi: [],
        tekmeFields: [
          {key: 'proti', label:'Nasprotnik'},
          {key: 'rezultat'},
          {key: '1pp', label: 'PM', sortable: true},
          {key: '2pp', label: '2T', sortable: true},
          {key: '3pp', label: '3T', sortable: true},
          {key: 'skoki', sortable: true},
          {key: 'asistence', sortable: true},
          {key: 'tocke', label: 'Točke', sortable: true},
        ],
        tekme: []
      }
    },
    computed: {
      id() {
        return this.$route.params.id
      }
    },
    methods: {
      nastopSelected(items) {
        this.$router.push('/zapisniki/' + items[0].tekma)
      },
      findNasprotnaEkipa(item){
        let tekma = this.tekme.find(tek => tek.id === item.tekma)
        if(this.ekipa.id === tekma.ekipa1){
          return this.ekipe.find(ek => ek.id === tekma.ekipa2).naziv
        }
        else{
          return this.ekipe.find(ek => ek.id === tekma.ekipa1).naziv
        }
      },
      findRezultatTekme(item){
        let tekma = this.tekme.find(tek => tek.id === item.tekma)
        return tekma.tocke1+':'+tekma.tocke2
      }
    },
    firestore() {
      return {
        igralec: db.collection('igralci').doc(this.$route.params.id),
        tekme: db.collection('tekme'),
        ekipe: db.collection('ekipe')
      }
    },
    watch: {
      igralec(val) {
        if (val && val.pozicija && val.ekipa) {
          this.$bind('pozicija', db.collection('pozicija').doc(val.pozicija))
          this.$bind('ekipa', db.collection('ekipe').doc(val.ekipa))
          this.$bind('nastopi', db.collection('rezultat').where('igralec', '==', val.id))
        }
      }
    }
  }
</script>

<style scoped>

</style>
