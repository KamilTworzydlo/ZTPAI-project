<template>
  <section class="login">
    <h1>Logowanie</h1>
    <p class="intro">
      Zaloguj się, aby zarządzać wypożyczeniami i zamówieniami.
    </p>

    <form @submit.prevent="submit">
      <input type="email" placeholder="Email" required />
      <input type="password" placeholder="Hasło" required />
      <button class="btn btn-primary">Zaloguj</button>
    </form>
  </section>
</template>

<script setup>
function submit() {
  alert("Logowanie demo – backend niezaimplementowany.");
}
</script>

<style scoped>
.login {
  max-width: 400px;
  margin: 0 auto;
}

.intro {
  margin-bottom: 1.5rem;
  color: #4b5563;
}

form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

input {
  padding: 0.6rem;
  font-size: 1rem;
}
</style>
