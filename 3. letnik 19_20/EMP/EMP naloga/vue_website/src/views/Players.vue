<template>
    <b-container>
        <b-row class="my-3">
            <b-col>
                <h1>Vsi igralci</h1>
            </b-col>
        </b-row>
        <b-row>
            <b-col>
                <b-table :items="igralci">
                    <template slot="slika" slot-scope="item">
                        <b-img :src="item.item.slika" height="20"></b-img>
                    </template>
                </b-table>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>
  import {db} from '@/firebaseConfig.js'

  export default {
    name: "Players",
    data: function () {
      return {
        igralci: []
      }
    },
    firestore() {
      return {
        igralci: db.collection('igralci')
      }
    }
  }
</script>

<style scoped>

</style>
