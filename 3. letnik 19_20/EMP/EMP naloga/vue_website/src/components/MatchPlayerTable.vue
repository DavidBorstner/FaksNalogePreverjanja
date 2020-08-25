<template>
  <b-row>
    <b-col>
      <b-table responsive :fields="igralciFields" :items="igralci">
        <template v-slot:cell(pozicija)="row">{{ row.value }}</template>
        <template v-slot:cell(igralec)="row">{{ row.item.priimek + " " + row.item.ime }}</template>
        <template v-slot:cell(1pp)="row">
          {{ getRezultat(row.item.id)['1pp'] }}
          <b-btn variant="success" v-if="allowEdit" @click="incrementScore('1pp', row.item.id, 1)">+</b-btn>
          <b-btn class="ml-1" v-if="allowEdit" @click="incrementScore('1pp', row.item.id, -1)">-</b-btn>
        </template>
        <template v-slot:cell(2pp)="row">
          {{ getRezultat(row.item.id)['2pp'] }}
          <b-btn variant="success" v-if="allowEdit" @click="incrementScore('2pp', row.item.id, 1)">+</b-btn>
          <b-btn class="ml-1" v-if="allowEdit" @click="incrementScore('2pp', row.item.id, -1)">-</b-btn>
        </template>
        <template v-slot:cell(3pp)="row">
          {{ getRezultat(row.item.id)['3pp'] }}
          <b-btn variant="success" v-if="allowEdit" @click="incrementScore('3pp', row.item.id, 1)">+</b-btn>
          <b-btn class="ml-1" v-if="allowEdit" @click="incrementScore('3pp', row.item.id, -1)">-</b-btn>
        </template>
        <template v-slot:cell(asistence)="row">
          {{ getRezultat(row.item.id)['asistence'] }}
          <b-btn variant="success" v-if="allowEdit" @click="incrementScore('as', row.item.id, 1)">+</b-btn>
          <b-btn class="ml-1" v-if="allowEdit" @click="incrementScore('as', row.item.id, -1)">-</b-btn>
        </template>
        <template v-slot:cell(skoki)="row">
          {{ getRezultat(row.item.id)['skoki'] }}
          <b-btn
            variant="success"
            v-if="allowEdit"
            @click="incrementScore('skoki', row.item.id, 1)"
          >+</b-btn>
          <b-btn class="ml-1" v-if="allowEdit" @click="incrementScore('skoki', row.item.id, -1)">-</b-btn>
        </template>
        <template v-slot:cell(tocke)="row">{{ getRezultat(row.item.id)['tocke'] }}</template>
      </b-table>
    </b-col>
  </b-row>
</template>

<script>
import { db, currentUser } from "@/firebaseConfig.js";
import firebase from "firebase";

export default {
  name: "MatchPlayerTable",
  props: ["tekmaId", "ekipaId", "ekipaNum", "tocke1", "tocke2"],
  data: function() {
    return {
      igralci: [],
      ekipa: null,
      rezultati: [],
      igralciFields: [
        "igralec",
        "pozicija",
        "1pp",
        "2pp",
        "3pp",
        "asistence",
        "skoki",
        "tocke"
      ],
      tekma: null,
      pozicija: [],
      pozicijePrepisane: false
    };
  },
  watch: {
    igralci: function(val, oldVal) {
      this.changePositions();
    },
    pozicija: function(val, oldVal) {
      this.changePositions();
    }
  },
  firestore() {
    return {
      ekipa: db.collection("ekipe").doc(this.ekipaId),
      igralci: db.collection("igralci").where("ekipa", "==", this.ekipaId),
      rezultati: db
        .collection("rezultat")
        .where("tekma", "==", this.tekmaId)
        .where("ekipa", "==", this.ekipaId),
      tekma: db.collection("tekme").doc(this.tekmaId),
      pozicija: db.collection("pozicija")
    };
  },
  computed: {
    allowEdit() {
      if (firebase.auth().currentUser) {
        return firebase.auth().currentUser.email === "neki@neki.com";
      }
      return false;
    }
  },
  methods: {
    zapisiDogodek(rez, cas, igralecId, dogodek) {
      db.collection("tekma-dogodek").add({
        cas: cas,
        dogodek: dogodek,
        igralec: igralecId,
        rezultat: rez,
        tekma: this.tekmaId
      });
    },
    changePositions() {
      if (this.pozicija.length && this.igralci.length) {
        this.igralci.forEach(ig => {
          ig.pozicija = this.pozicija.find(po => {
            this.pozicijePrepisane = true;
            return po.id == ig.pozicija;
          }).pozicija;
        });
      }
    },
    getRezultat(igralecId) {
      return this.rezultati.filter(el => el.igralec == igralecId)[0] || {};
    },
    incrementScore(tip, igralecId, amt) {
      let done = false;
      switch (tip) {
        case "1pp":
          db.collection("rezultat")
            .where("igralec", "==", igralecId)
            .where("tekma", "==", this.tekmaId)
            .get()
            .then(res => {
              res.forEach(el => {
                el.ref.update({
                  "1pp": firebase.firestore.FieldValue.increment(amt),
                  "tocke": firebase.firestore.FieldValue.increment(1)
                });
              });
              db.collection("tekme")
                .doc(this.tekmaId)
                .get()
                .then(res => {
                  // a je ekipa1 al ekipa2
                  let obj = {};
                  if (this.ekipaNum == 1)
                    Object.assign(obj, {
                      tocke1: firebase.firestore.FieldValue.increment(1 * amt)
                    });
                  if (this.ekipaNum == 2)
                    Object.assign(obj, {
                      tocke2: firebase.firestore.FieldValue.increment(1 * amt)
                    });
                  res.ref.update(obj).then(() => {
                    this.zapisiDogodek(
                      this.tocke1 + ":" + this.tocke2,
                      new Date(),
                      igralecId,
                      tip
                    );
                  });
                });
            });
          break;
        case "2pp":
          db.collection("rezultat")
            .where("igralec", "==", igralecId)
            .where("tekma", "==", this.tekmaId)
            .get()
            .then(res => {
              res.forEach(el => {
                el.ref.update({
                  "2pp": firebase.firestore.FieldValue.increment(amt),
                  "tocke": firebase.firestore.FieldValue.increment(2)
                });
              });
              db.collection("tekme")
                .doc(this.tekmaId)
                .get()
                .then(res => {
                  // a je ekipa1 al ekipa2
                  let obj = {};
                  if (this.ekipaNum == 1)
                    Object.assign(obj, {
                      tocke1: firebase.firestore.FieldValue.increment(2 * amt)
                    });
                  if (this.ekipaNum == 2)
                    Object.assign(obj, {
                      tocke2: firebase.firestore.FieldValue.increment(2 * amt)
                    });
                  res.ref.update(obj).then(() => {
                    this.zapisiDogodek(
                      this.tocke1 + ":" + this.tocke2,
                      new Date(),
                      igralecId,
                      tip
                    );
                  });
                });
            });
          break;
        case "3pp":
          db.collection("rezultat")
            .where("igralec", "==", igralecId)
            .where("tekma", "==", this.tekmaId)
            .get()
            .then(res => {
              res.forEach(el => {
                el.ref.update({
                  "3pp": firebase.firestore.FieldValue.increment(amt),
                  "tocke": firebase.firestore.FieldValue.increment(3)
                });
              });
              db.collection("tekme")
                .doc(this.tekmaId)
                .get()
                .then(res => {
                  // a je ekipa1 al ekipa2
                  let obj = {};
                  if (this.ekipaNum == 1)
                    Object.assign(obj, {
                      tocke1: firebase.firestore.FieldValue.increment(3 * amt)
                    });
                  if (this.ekipaNum == 2)
                    Object.assign(obj, {
                      tocke2: firebase.firestore.FieldValue.increment(3 * amt)
                    });
                  res.ref.update(obj).then(() => {
                    this.zapisiDogodek(
                      this.tocke1 + ":" + this.tocke2,
                      new Date(),
                      igralecId,
                      tip
                    );
                  });
                });
            });
          break;
        case "as":
          db.collection("rezultat")
            .where("igralec", "==", igralecId)
            .where("tekma", "==", this.tekmaId)
            .get()
            .then(res => {
              res.forEach(el => {
                el.ref
                  .update({
                    asistence: firebase.firestore.FieldValue.increment(amt)
                  })
                  .then(() => {
                    this.zapisiDogodek(
                      this.tocke1 + ":" + this.tocke2,
                      new Date(),
                      igralecId,
                      tip
                    );
                  });
              });
            });
          break;
        case "skoki":
          db.collection("rezultat")
            .where("igralec", "==", igralecId)
            .where("tekma", "==", this.tekmaId)
            .get()
            .then(res => {
              res.forEach(el => {
                el.ref
                  .update({
                    skoki: firebase.firestore.FieldValue.increment(amt)
                  })
                  .then(() => {
                    this.zapisiDogodek(
                      this.tocke1 + ":" + this.tocke2,
                      new Date(),
                      igralecId,
                      tip
                    );
                  });
              });
            });
          break;
      }
      // update match score

      // zapiši dogodek za live feed¸
    }
  }
};
</script>

<style scoped>
</style>
