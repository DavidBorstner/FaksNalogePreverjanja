<template>
  <b-container>
    <b-row class="my-3 justify-content-between">
      <b-col cols="auto">
        <h1>{{ ( allowEdit ? 'Zapisniki' : 'Pretekle tekme' ) }}</h1>
      </b-col>
      <b-col cols="auto">
        <b-btn v-if="allowEdit" @click="showModal">Nova tekma</b-btn>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table :fields="tekmeFields" :items="tekme">
          <template v-slot:cell(ekipa1)="row">{{ getEkipa(row.item.ekipa1) }}</template>
          <template v-slot:cell(ekipa2)="row">{{ getEkipa(row.item.ekipa2) }}</template>
          <template v-slot:cell(datum)="row">{{ getDatum(row.item.datum) }}</template>
          <template v-slot:cell(dvorana)="row">{{ getDvorana(row.item.dvorana) }}</template>
          <template v-slot:cell(more)="row">
            <b-btn
              :to="'/zapisniki/'+row.item.id+'/'"
              variant="success"
            >{{ ( allowEdit ? 'Zapisnik' : 'Rezultati' ) }}</b-btn>
          </template>
        </b-table>
      </b-col>
    </b-row>
    <b-modal ref="addMatchModal" title="Nova tekma" hide-footer>
      <b-form @submit.prevent="addNewMatch">
        <b-form-group label="Domači">
          <b-select v-model="novaTekma.ekipa1" text-field="naziv" value-field="id" :options="ekipe"></b-select>
        </b-form-group>
        <b-form-group label="Gostje">
          <b-select v-model="novaTekma.ekipa2" text-field="naziv" value-field="id" :options="ekipe"></b-select>
        </b-form-group>
        <b-form-group label="Dvorana">
          <b-select
            v-model="novaTekma.dvorana"
            text-field="naziv"
            value-field="id"
            :options="dvorane"
          ></b-select>
        </b-form-group>
        <b-row class="justify-content-center">
          <b-col cols="auto">
            <b-btn type="submit" variant="success">Dodaj tekmo</b-btn>
          </b-col>
        </b-row>
      </b-form>
    </b-modal>
  </b-container>
</template>

<script>
import { db } from "@/firebaseConfig.js";
import firebase from "firebase";
export default {
  name: "MatchInput",
  data: function() {
    return {
      ekipe: [],
      dvorane: [],
      tekme: [],
      novaTekma: {
        dvorana: null,
        ekipa1: null,
        ekipa2: null,
        datum: new Date(),
        tocke1: 0,
        tocke2: 0
      },
      tekmeFields: [
        { key: "ekipa1", label: "Prva ekipa" },
        { key: "ekipa2", label: "Druga ekipa" },
        { key: "datum", label: "Datum" },
        { key: "dvorana", label: "Dvorana" },
        { key: "more", label: "" }
      ]
    };
  },
  methods: {
    addNewMatch() {
      db.collection("tekme")
        .add(this.novaTekma)
        .then(res => {
          this.hideModal();
          // za vsakega igralca dodaj "rezultat"
          // najprej prva ekipa
          const ek1 = this.novaTekma.ekipa1;
          const ek2 = this.novaTekma.ekipa2;
          const tekmaId = res.id;

          db.collection("igralci")
            .where("ekipa", "==", ek1)
            .get()
            .then(res => {
              res.forEach(igralec => {
                db.collection("rezultat").add({
                  igralec: igralec.id,
                  ekipa: ek1,
                  tekma: tekmaId,
                  "1pp": 0,
                  "2pp": 0,
                  "3pp": 0,
                  asistence: 0,
                  skoki: 0,
                  tocke:0
                });
              });
            });
            db.collection("igralci")
            .where("ekipa", "==", ek2)
            .get()
            .then(res => {
              res.forEach(igralec => {
                db.collection("rezultat").add({
                  igralec: igralec.id,
                  ekipa: ek2,
                  tekma: tekmaId,
                  "1pp": 0,
                  "2pp": 0,
                  "3pp": 0,
                  asistence: 0,
                  skoki: 0,
                  tocke:0
                });
              });
            });

          this.novaTekma = {
            dvorana: null,
            ekipa1: null,
            ekipa2: null,
            datum: new Date()
          };
        });
    },
    showModal() {
      this.$refs.addMatchModal.show();
    },
    hideModal() {
      this.$refs.addMatchModal.hide();
    },
    getEkipa(id) {
      return this.ekipe.filter(el => el.id === id)[0].naziv;
    },
    getDatum(ts) {
      let datum = new Date(1970, 0, 1);
      datum.setSeconds(ts.seconds);
      return datum.toDateString();
    },
    getDvorana(id) {
      return this.dvorane.filter(el => el.id === id)[0].naziv;
    },
    showZapisnik(matchId) {
      this.$router.push(matchId + "/");
    }
  },
  firestore() {
    return {
      ekipe: db.collection("ekipe"),
      dvorane: db.collection("dvorane"),
      tekme: db.collection("tekme")
    };
  },
  watch: {
    "novaTekma.ekipa1": function(val) {
      this.novaTekma.dvorana = this.ekipe.filter(
        el => el.id === val
      )[0].dvorana;
    }
  },
  computed: {
    allowEdit() {
      if (firebase.auth().currentUser) {
        return firebase.auth().currentUser.email === "neki@neki.com";
      }
      return false;
    }
  }
};
</script>

<style scoped>
</style>
