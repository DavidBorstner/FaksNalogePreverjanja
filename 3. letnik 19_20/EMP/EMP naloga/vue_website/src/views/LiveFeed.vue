<template>
  <b-container>
    <b-row>
      <b-col>
        <b-row align-v="end" align-h="between">
          <b-col v-if="prvaEkipa" cols="auto">
            <b-img :src="prvaEkipa.logo"></b-img>
            <h2>{{ prvaEkipa.naziv }}</h2>
            <h1>{{tekma.tocke1}}</h1>
          </b-col>
          <b-col v-if="drugaEkipa" cols="auto">
            <b-img :src="drugaEkipa.logo"></b-img>
            <h2>{{ drugaEkipa.naziv }}</h2>
            <h1>{{tekma.tocke2}}</h1>
          </b-col>
        </b-row>
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table v-if="igralci.length && ekipe.length" :fields="fields" :items="dogodki">
          <!--<template
            v-slot:cell(cas)="row"
          >{{ row.item.cas.toDate().getMinutes()+":"+row.item.cas.toDate().getSeconds() }}</template>-->
          <template v-slot:cell(igralec)="row">{{ getIgralec(row.item.igralec).priimek + " " + getIgralec(row.item.igralec).ime }}</template>
          <template v-slot:cell(dogodek)="row">{{ getDogodek(row.item.dogodek) }}</template>
          <template v-slot:cell(ekipa)="row">{{ ekipe.find(ek=>ek.id==getIgralec(row.item.igralec).ekipa).naziv }}</template>
        </b-table>
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
      igralci: [],
      rezultati1: [],
      rezultati2: [],
      // Note `isActive` is left out and will not appear in the rendered table
      fields: [
        { key: "rezultat", label: "Rezultat" },
        { key: "igralec", label: "Igralec" },
        { key: "ekipa", label: "Ekipa" },
        { key: "dogodek", label: "Dogodek" }
      ],
      dogodki: [],
      itemsDogodki: [],
      ekipe: []
    };
  },
  methods: {
    getIgralec(pid) {
      return this.igralci.find(ig => ig.id == pid)
    },
    getDogodek(str) {
      switch (str) {
        case "as":
          return "Igralec je asistiral.";
        case "skoki":
          return "Igralec je skočil.";
        case "1pp":
          return "Igralec je zadel prosti met.";
        case "2pp":
          return "Igralec je zadel met za 2 točki.";
        case "3pp":
          return "Igralec je zadel trojko.";
      }
    }
  },
  firestore() {
    return {
      tekma: db.collection("tekme").doc(this.$route.params.id),
      dogodki: db
        .collection("tekma-dogodek")
        .orderBy("cas", "desc")
        .where("tekma", "==", this.$route.params.id),
      igralci: db.collection("igralci"),
      ekipe: db.collection("ekipe")
    };
  },
  watch: {
    tekma: function(tekma, oldTekma) {
      if (tekma != null && typeof tekma != undefined) {
        if (tekma.ekipa1 != oldTekma.ekipa1) {
          db.collection("ekipe")
            .doc(tekma.ekipa1)
            .get()
            .then(doc => {
              if (doc.exists) {
                this.prvaEkipa = Object.assign(doc.data(), { id: doc.id });
              }
            });
        }
        if (tekma.ekipa2 != oldTekma.ekipa2) {
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
    },
    prvaEkipa(ekipa1) {
      /* this.$bind(
        "igralci1",
        db.collection("igralci").where("ekipa", "==", ekipa1.id)
      );
      this.$bind(
        "rezultati1",
        db
          .collection("rezultat")
          .where("ekipa", "==", ekipa1.id)
          .where("tekma", "==", this.tekma.id)
      ); */
    },
    drugaEkipa(ekipa2) {
      /* this.$bind(
        "igralci2",
        db.collection("igralci").where("ekipa", "==", ekipa2.id)
      );
      this.$bind(
        "rezultati2",
        db
          .collection("rezultat")
          .where("ekipa", "==", ekipa2.id)
          .where("tekma", "==", this.tekma.id)
      ); */
    }
  }
};
</script>

<style>
</style>