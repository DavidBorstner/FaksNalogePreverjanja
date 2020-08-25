<template>
  <b-container fluid>
    <b-row class="my-3 justify-content-between">
      <b-col xs="12" md="4">
        <h2 v-if="prvaEkipa">
          <b-img class="my-3" height="100" :src="prvaEkipa.logo"></b-img>
          <p>{{ prvaEkipa.naziv }}</p>
        </h2>
      </b-col>
      <b-col xs="12" md="4" v-if="tekma" class="text-center">
        <h1 style="position: relative; top: 26%;">{{ tekma.tocke1 }} : {{ tekma.tocke2 }}</h1>
        <br />
        <h5 class="mt-3">
          <router-link :to="'live/'">Živi podatki</router-link>
        </h5>
      </b-col>
      <b-col xs="12" md="4">
        <h2 v-if="drugaEkipa">
          <b-img class="my-3" height="100" :src="drugaEkipa.logo"></b-img>
          <p>{{ drugaEkipa.naziv }}</p>
        </h2>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-tabs fill>
          <b-tab :title="prvaNaziv.naziv">
            <b-row class="mb-5">
              <b-col>
                <br />
                <match-player-table
                  :tocke1="tekma.tocke1"
                  :tocke2="tekma.tocke2"
                  ekipaNum="1"
                  v-if="prvaEkipa && tekma"
                  :ekipaId="prvaEkipa.id"
                  :tekmaId="tekma.id"
                ></match-player-table>
              </b-col>
            </b-row>
          </b-tab>
          <b-tab :title="drugaNaziv.naziv">
            <b-row class="mb-5">
              <b-col>
                <br />
                <match-player-table
                  :tocke1="tekma.tocke1"
                  :tocke2="tekma.tocke2"
                  ekipaNum="2"
                  v-if="drugaEkipa && tekma"
                  :ekipaId="drugaEkipa.id"
                  :tekmaId="tekma.id"
                ></match-player-table>
              </b-col>
            </b-row>
          </b-tab>
        </b-tabs>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { db } from "@/firebaseConfig.js";

export default {
  name: "Match",
  data: function() {
    return {
      tekma: {
        dvorana: null,
        ekipa1: null,
        ekipa2: null,
        datum: null
      },
      dvorana: null,
      prvaEkipa: null,
      drugaEkipa: null,
      igralci1: [],
      igralci2: [],
      rezultati1: [],
      rezultati2: []
    };
  },
  firestore() {
    return {
      tekma: db.collection("tekme").doc(this.$route.params.id)
    };
  },
  computed: {
    scorePrva() {
      let ret = 0;
      this.rezultati1.forEach(el => (ret += el.tocke));
      return ret;
    },
    scoreDruga() {
      let ret = 0;
      this.rezultati2.forEach(el => (ret += el.tocke));
      return ret;
    },
    prvaNaziv() {
      return this.prvaEkipa || { naziv: "" };
    },
    drugaNaziv() {
      return this.drugaEkipa || { naziv: "" };
    }
  },
  watch: {
    tekma: function(tekma, oldTekma) {
      if (tekma != null && typeof tekma != undefined) {
        if (oldTekma.dvorana != tekma.dvorana) {
          db.collection("dvorane")
            .doc(tekma.dvorana)
            .get()
            .then(doc => {
              if (doc.exists) {
                this.dvorana = Object.assign(doc.data(), { id: doc.id });
              }
            });
        }
        if (oldTekma.ekipa1 != tekma.ekipa1) {
          db.collection("ekipe")
            .doc(tekma.ekipa1)
            .get()
            .then(doc => {
              if (doc.exists) {
                this.prvaEkipa = Object.assign(doc.data(), { id: doc.id });
              }
            });
        }
        if (oldTekma.ekipa2 != tekma.ekipa2) {
          db.collection("ekipe")
            .doc(tekma.ekipa2)
            .get()
            .then(doc => {
              if (doc.exists) {
                this.drugaEkipa = Object.assign(doc.data(), { id: doc.id });
              }
            });
        }
      }

      //this.$bind("dvorana", db.collection("dvorane").doc(tekma.dvorana));
      //this.$bind("prvaEkipa", db.collection("ekipe").doc(tekma.ekipa1));
      // this.$bind("drugaEkipa", db.collection("ekipe").doc(tekma.ekipa2));
    },
    prvaEkipa: function(ekipa1) {
      if (this.prvaEkipa) {
        this.$bind(
          "igralci1",
          db.collection("igralci").where("ekipa", "==", ekipa1.id)
        );
        this.$bind(
          "rezultati1",
          db
            .collection("rezultat")
            .where("ekipa", "==", ekipa1.id)
            .where("tekma", "==", this.tekma.id)
        );
      }
    },
    drugaEkipa: function(ekipa2) {
      if (this.drugaEkipa) {
        this.$bind(
          "igralci2",
          db.collection("igralci").where("ekipa", "==", ekipa2.id)
        );
        this.$bind(
          "rezultati2",
          db
            .collection("rezultat")
            .where("ekipa", "==", ekipa2.id)
            .where("tekma", "==", this.tekma.id)
        );
      }
    }
  }
};
</script>

<style scoped>
</style>
