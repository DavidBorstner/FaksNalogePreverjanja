<template>
    <b-container v-if="user">
        <v-layout row class="mb-3">
            <v-flex xs12>
                <h1>Vpis podatkov</h1>
            </v-flex>
        </v-layout>
        <v-layout row wrap>
            <v-flex xs12 md6 class="pa-3">
                <h3>Dvorane</h3>
                <v-text-field v-model="newDvorana.kapaciteta" type="number" label="Kapaciteta"></v-text-field>
                <v-text-field v-model="newDvorana.naziv" label="Naziv"></v-text-field>
                <v-text-field v-model="newDvorana.kraj" label="Kraj"></v-text-field>
                <v-btn @click="addDvorana">Dodaj dvorano</v-btn>
            </v-flex>
            <v-flex xs12 md6 class="pa-3">
                <h3>Trenerji</h3>
                <v-text-field v-model="newTrener.ime" label="Ime"></v-text-field>
                <v-text-field v-model="newTrener.priimek" label="Priimek"></v-text-field>
                <v-btn @click="addTrener">Dodaj trenerja</v-btn>
            </v-flex>
            <v-flex xs12 md6 class="pa-3">
                <h3>Ekipe</h3>
                <v-select
                        item-value="id"
                        :items="trenerji"
                        label="Trenerji"
                        v-model="newEkipa.trener"
                ></v-select>
                <v-select
                        item-value="id"
                        :items="dvorane"
                        label="Dvorane"
                        v-model="newEkipa.dvorana"
                ></v-select>
                <v-text-field v-model="newEkipa.naziv" label="Naziv"></v-text-field>
                <v-text-field v-model="newEkipa.opis" label="Opis"></v-text-field>
                <v-text-field v-model="newEkipa.logo" label="Logo"></v-text-field>
                <v-btn @click="addEkipa">Dodaj ekipo</v-btn>
            </v-flex>
            <v-flex xs12 md6 class="pa-3">
                <h3>Igralci</h3>
                <v-text-field v-model="newIgralec.ime" label="Ime"></v-text-field>
                <v-text-field v-model="newIgralec.priimek" label="Priimek"></v-text-field>
                <v-text-field v-model="newIgralec.slika" label="Slika"></v-text-field>
                <v-text-field v-model="newIgralec.teza" label="Teža"></v-text-field>
                <v-text-field v-model="newIgralec.visina" label="Višina"></v-text-field>
                <v-select
                        item-text="pozicija"
                        item-value="id"
                        :items="pozicije"
                        label="Pozicija"
                        v-model="newIgralec.pozicija"
                ></v-select>
                <v-select
                        item-text="naziv"
                        item-value="id"
                        :items="ekipe"
                        label="Ekipa"
                        v-model="newIgralec.ekipa"
                ></v-select>
                <v-btn @click="addIgralec">Dodaj igralca</v-btn>
            </v-flex>
        </v-layout>
    </b-container>
</template>

<script>
  import {db} from '@/firebaseConfig.js'

  export default {
    name: "DataInput",
    data: function () {
      return {
        newDvorana: {
          kapaciteta: null,
          naziv: null,
          kraj: null
        },
        newTrener: {
          ime: null,
          priimek: null
        },
        trenerji: [],
        dvorane: [],
        ekipaTrener: {
          id: null,
          ime: '',
          priimek: ''
        },
        newEkipa: {
          trener: null,
          dvorana: null,
          logo: null,
          naziv: null,
          opis: null
        },
        newDvorana: {
          kapaciteta: null,
          kraj: null,
          naziv: null
        },
        newIgralec: {
          ime: null,
          pozicija: null,
          priimek: null,
          slika: null,
          teza: null,
          visina: null,
          ekipa: null
        },
        pozicije: [],
        ekipe: []
      }
    },
    methods: {
      addDvorana() {
        db.collection('dvorane').add(this.newDvorana)
        this.newDvorana = {
          kapaciteta: null,
          naziv: null,
          kraj: null
        }
      },
      addTrener() {
        db.collection('trener').add(this.newTrener)
        this.newTrener = {
          ime: null,
          priimek: null
        }
      },
      addEkipa() {
        db.collection('ekipe').add(this.newEkipa)
        this.newEkipa = {
          trener: null,
          dvorana: null,
          logo: null,
          naziv: null,
          opis: null
        }
      },
      addIgralec(){
        db.collection('igralci').add(this.newIgralec)
      }
    },
    firestore() {
      return {
        pozicije: db.collection('pozicija'),
        ekipe: db.collection('ekipe')
      }
    },
    watch: {
      ekipaTrener: function (val) {
        console.log(val)
      }
    },
    computed: {
      user() {
        return this.$store.state.user
      }
    },
    async mounted() {
      const snapshotTrener = await db.collection('trener').get()
      snapshotTrener.docs.forEach(item => {
        let data = item.data()
        this.trenerji.push({
          id: item.id,
          ime: data.ime,
          priimek: data.priimek,
          text: data.ime + ' ' + data.priimek
        })
      })

      const snapshotDvorana = await db.collection('dvorane').get()
      snapshotDvorana.docs.forEach(item => {
        let data = item.data()
        this.dvorane.push({
          id: item.id,
          kapaciteta: data.kapaciteta,
          naziv: data.naziv,
          kraj: data.kraj,
          text: data.naziv + ' ' + data.kraj
        })
      })
    }
  }
</script>

<style scoped>

</style>
