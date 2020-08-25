<template>
    <p>
        {{ user }}
        <v-btn @click="signOut">Sign out</v-btn>
    </p>
</template>

<script>
    import firebase from 'firebase'
  export default {
    name: "Secret",
    methods: {
      signOut(){
        firebase.auth().signOut()
          .then(() => {
            this.$store.state.user = null
            this.$router.replace('/')
          })
      }
    },
    computed: {
      user() {
        return this.$store.state.user
      }
    }
  }
</script>

<style scoped>

</style>
