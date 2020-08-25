<template>
    <div id="app">
        <b-navbar toggleable="lg" type="dark" variant="success">
            <b-navbar-brand to="/">Statistika</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item to="/">Domov
                        <fa-icon icon="home"/>
                    </b-nav-item>
                    <b-nav-item to="/zapisniki/">{{ ( allowEdit ? 'Zapisniki' : 'Pretekle tekme' ) }}
                        <fa-icon icon="pen"/>
                    </b-nav-item>
                    <!-- 
                      <b-nav-item to="/about/">O strani
                        <fa-icon icon="info-circle"/>
                    </b-nav-item>
                    -->
                    
                </b-navbar-nav>
                <b-navbar-nav class="ml-auto">
                    <b-nav-item-dropdown v-if="user" right>
                        <template slot="button-content"><em>{{ user.email }}</em></template>
                        <b-dropdown-item @click="logOut">Izpis</b-dropdown-item>
                    </b-nav-item-dropdown>
                    <b-nav-item v-else to="/login/">Prijava</b-nav-item>
                </b-navbar-nav>

            </b-collapse>
        </b-navbar>
        <router-view></router-view>
    </div>
</template>

<script>
  require('@/assets/css/style.css')
  import firebase from 'firebase'

  export default {
    data: () => ({
      drawer: false,
      footer_links: [],
      items: [
        {title: 'Domov', icon: 'home', link: '/'},
        {title: 'Igralci', icon: 'person', link: '/igralci/'},
        {title: 'Statistika', icon: 'insert_chart', link: '/statistika/'},
        {title: 'Lestvica', icon: 'sort', link: '/lestvica/'},
        {title: 'Tekme', icon: 'tv', link: '/tekme/'},
        {title: 'Zapisniki', icon: 'event_note', link: '/zapisniki/'},
        {title: 'Vpis podatkov', icon: 'note', link: '/datainput/', auth: true}
      ],
      right: null,
      social: [
        {icon: 'fab fa-facebook', link: 'http://www.facebook.com'},
        {icon: 'fab fa-twitter', link: '/'},
        {icon: 'fab fa-google-plus', link: '/'},
        {icon: 'fab fa-linkedin', link: '/'},
        {icon: 'fab fa-instagram', link: '/'}
      ],
      right: null,
    }),
    methods: {
      logOut(){
        firebase.auth().signOut()
        this.$store.state.user = null
        this.$router.go()
      }
    },
    computed: {
      user() {
        return this.$store.state.user
      },
      allowEdit(){
        if(firebase.auth().currentUser){
          return firebase.auth().currentUser.email === 'neki@neki.com'
        }
        return false
      }
    },
    mounted() {

    }
  }
</script>
