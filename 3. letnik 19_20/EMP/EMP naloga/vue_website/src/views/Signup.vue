<template>
    <v-layout justify-center row fill-height>
        <v-flex sm12 md6 lg4>
            <v-form @submit.prevent="loginUser">
                <v-text-field v-model="email" label="Email" required></v-text-field>
                <v-text-field v-model="password" label="Geslo" required type="password"></v-text-field>
                <v-btn color="primary" type="submit">Ustvari račun</v-btn>
                Ali že imaš račun?
                <router-link to="/login" flat> Prijavi se</router-link>
            </v-form>
        </v-flex>
        <v-snackbar
                bottom
                v-model="snackbar"
                :color="color"
                :timeout="timeout">
            {{ text }}
            <v-btn
                    dark
                    flat
                    @click="snackbar = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-layout>
</template>

<script>
  import firebase from 'firebase'

  export default {
    name: "Signup",
    data: function () {
      return {
        email: null,
        password: null,
        snackbar: false,
        color: 'error',
        timeout: 6000,
        text: 'Wrong email and password combination'
      }
    },
    methods: {
      loginUser() {
        // this.$store.dispatch('userSignUp', {email: this.email, password: this.password})
        //   .then((data) => {
        //
        //   })
        //   .catch((err) => {
        //     this.showSnackbar(err)
        //   })
        this.text = 'Registracija neomogočena'
        this.snackbar = true
      },
      showSnackbar(err) {
        this.text = err.message
        this.snackbar = true
      }
    }
  }
</script>

<style scoped>

</style>
