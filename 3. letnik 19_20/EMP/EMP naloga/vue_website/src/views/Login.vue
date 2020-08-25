<template>
    <b-container>
        <b-row class="justify-content-center">
            <b-col lg="4" cols="auto">
                <b-form @submit.prevent="loginUser">
                    <h1 class="my-3">Prijava</h1>
                    <b-form-group label="E-mail">
                        <b-form-input type="email" v-model="email"></b-form-input>
                    </b-form-group>
                    <b-form-group label="Geslo">
                        <b-form-input type="password" v-model="password"></b-form-input>
                    </b-form-group>
                    <b-row class="justify-content-center mb-3">
                        <b-col cols="auto">
                            <b-btn type="submit">Prijava</b-btn>
                        </b-col>
                    </b-row>
<!--                    <b-row class="justify-content-center">-->
<!--                        <b-col cols="auto">-->
<!--                            Ali še nimaš računa?-->
<!--                            <router-link to="/signup"> Ustvari ga tukaj</router-link>-->
<!--                        </b-col>-->
<!--                    </b-row>-->
                </b-form>
            </b-col>
        </b-row>
    </b-container>

</template>

<script>
  export default {
    name: "Login",
    data: function () {
      return {
        email: null,
        password: null
      }
    },
    methods: {
      loginUser() {
        this.$store.dispatch('userSignIn', {email: this.email, password: this.password})
          .then((data) => {
            this.$router.go()
          })
          .catch((err) => {
            this.showSnackbar(err)
          })
      }
    }
  }
</script>

<style scoped>

</style>
