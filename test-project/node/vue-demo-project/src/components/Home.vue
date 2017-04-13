<template>
<div>
  <h1>{{ msg }}</h1>
    <ul>
        <router-link to='/login'>login-session</router-link>
    </ul>
  </div>
</template>

<script>

export default {
  data () {
    return {
      msg: 'Welcome To Login Examples'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
html, body {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
  color: #2c3e50;
  }

  ul {
    line-height: 1.5em;
    padding-left: 1.5em;
  }
  a {
    color: #7f8c8d;
    text-decoration: none;
    }
  a:hover {
    color: #4fc08d;
    }
</style>
