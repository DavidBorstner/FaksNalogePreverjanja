<template>
    <b-container>
        
        <b-row class="justify-content-center">
            <b-col cols="auto">
                <router-link v-for="(e, index) in ekipeZLogom" :to="'/ekipe/'+e.id" :key="index">
                    <b-img v-if="e.logo" :src="e.logo">
                    </b-img>
                </router-link>
            </b-col>
        </b-row>
      
        <b-row class="mb-5">
            <b-col>
                <b-tabs fill>
                    <b-tab title-link-class="tab-item-link" title-item-class="tab-item-home" title="Zadnje tekme">
                        <b-row class="my-3">
                            <b-col>
                                <h3 class="my-3">Zadnjih 20 vnešenih tekem</h3>
                                <b-table :fields="tekmeFields" :items="tekme">
                                    <template v-slot:cell(ekipa1)="row">
                                        {{ ekipe.find(el => el.id === row.value).naziv }}
                                    </template>
                                    <template v-slot:cell(ekipa2)="row">
                                        {{ ekipe.find(el => el.id === row.value).naziv }}
                                    </template>
                                    <template v-slot:cell(rezultat)="row">
                                        {{ row.item.tocke1 }}:{{ row.item.tocke2 }}
                                    </template>
                                    <template v-slot:cell(zapisnik)="row">
                                        <b-btn :to="'/zapisniki/'+row.item.id+'/'" variant="success">{{ ( allowEdit ? 'Zapisnik' : 'Rezultati' ) }}</b-btn>
                                    </template>
                                </b-table>
                            </b-col>
                        </b-row>
                    </b-tab>
                    <b-tab title-link-class="tab-item-link" title-item-class="tab-item-home" title="Vodilni v statistiki">
                        <b-row class="my-3">
                            <b-col>
                                <h3 class="my-3">Top 20</h3>
                                <b-table selectable
                                         select-mode="single"
                                         selectedVariant="success"
                                         @row-selected="liderSelected" :fields="liderjiFields" :items="liderji.slice(0,20)">
                                    <template slot="mesto" slot-scope="row">
                                        {{ row.index+1 }}
                                    </template>
                                </b-table>
                            </b-col>
                        </b-row>
                    </b-tab>
                </b-tabs>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>
  import {db} from '@/firebaseConfig.js'
  import firebase from 'firebase'

  export default {
    name: 'home',
    data: function () {
      return {
        ekipe: [],
        tekme: [],
        tekmeFields: [
          {key: 'ekipa1', label: 'Domači'},
          {key: 'ekipa2', label: 'Gostje'},
          {key: 'rezultat'},
          {key: 'zapisnik', label: ''}
        ],
        liderji: [],
        rezultati: [],
        igralci: [],
        liderjiFields: [
          {key: 'mesto', label: ''},
          {key: 'priimek'},
          {key: 'ime'},
          {key: 'ekipa'},
          {key: 'asistence', sortable: true},
          {key: 'rebounds', sortable: true},
          {key: 'tocke', label: 'Točke', sortable: true},
          {key: 'povprecje', label: 'Povprečje točk', sortable: true}
        ]
      }
    },
    methods: {
      loadLeaders() {
        if (this.rezultati.length > 0 && this.igralci.length > 0) {
          this.liderji = []
          this.rezultati.forEach(rez => {
            const ekipaNaziv = this.ekipe.find(ek => ek.id === rez.ekipa) && this.ekipe.find(ek => ek.id === rez.ekipa).naziv || ''
            if (this.liderji.findIndex(lid => lid.id === rez.igralec) !== -1) {
              const id = this.liderji.findIndex(lid => lid.id === rez.igralec)
              const current = this.liderji[id]
              let newLider = Object.assign({}, {
                id: current.id,
                ime: current.ime,
                priimek: current.priimek,
                ekipa: ekipaNaziv,
                asistence: current.asistence+rez.asistence,
                rebounds: current.rebounds+rez.skoki,
                tocke: current.tocke+rez.tocke,
              })
              this.liderji[id] = newLider
            } else {
              const igralec = this.igralci.find(ig => ig.id === rez.igralec)
              if(igralec){
                this.liderji.push({
                  id: rez.igralec,
                  ime: igralec.ime,
                  priimek: igralec.priimek,
                  ekipa: ekipaNaziv,
                  asistence: rez.asistence,
                  rebounds: rez.skoki,
                  tocke: rez.tocke
                })
              }
            }
          })
        }
        this.liderji.sort(function(a, b){
          if(a.tocke > b.tocke) return -1;
          if(a.tocke < b.tocke) return 1;
          return 0;
        });
        this.liderji.forEach(lid => {
          lid.povprecje = this.getAvg(lid)
        })
      },
      liderSelected(item){
        this.$router.push('/igralci/'+item[0].id)
      },
      getAvg(item){
        let sum = 0
        let rez = this.rezultati.filter(rez => rez.igralec === item.id)
        rez.forEach(el => sum+=el.tocke)
        return (sum/rez.length).toFixed(2)
      }
    },
    firestore() {
      return {
        ekipe: db.collection('ekipe'),
        tekme: db.collection('tekme'),
        rezultati: db.collection('rezultat'),
        igralci: db.collection('igralci')
      }
    },
    watch: {
      rezultati() {
        this.loadLeaders()
      },
      igralci() {
        this.loadLeaders()
      }
    },
    computed: {
      ekipeZLogom() {
        let ret = []
        this.ekipe.forEach(e => {
          if (e.logo) {
            ret.push(e)
          }
        })
        return ret
      },
      allowEdit(){
        if(firebase.auth().currentUser){
          return firebase.auth().currentUser.email === 'jneki@neki.com'
        }
        return false
      }
    }
  }
</script>
<style scoped>

</style>
