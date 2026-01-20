<script setup>
import { ref } from "vue";

const email = ref("");
const password = ref("");
const error = ref(null);

function submit() {
  error.value = null;

  if (!email.value || !password.value) {
    error.value = "Uzupełnij email oraz hasło.";
    return;
  }

  // Mock logowania – backend niezaimplementowany
  alert(
    "Logowanie demo\n\nEmail: " +
      email.value +
      "\n(hasło nie jest wysyłane)"
  );

  email.value = "";
  password.value = "";
}
</script>

<template>
  <section class="login">
    <h1>Logowanie</h1>

    <p class="intro">
      Zaloguj się, aby zarządzać wypożyczeniami, sprawdzać dostępność sprzętu
      oraz kontaktować się z wypożyczalnią.
    </p>

    <form @submit.prevent="submit" class="login-form">
      <label>
        Email
        <input
          type="email"
          v-model="email"
          placeholder="adres@email.pl"
        />
      </label>

      <label>
        Hasło
        <input
          type="password"
          v-model="password"
          placeholder="••••••••"
        />
      </label>

      <p v-if="error" class="error">{{ error }}</p>

      <button class="btn btn-primary">Zaloguj się</button>
    </form>

    <p class="hint">
      * Logowanie demonstracyjne – funkcjonalność backendowa nie jest
      zaimplementowana.
    </p>
  </section>
</template>

<style scoped>
.login {
  max-width: 420px;
  margin: 0 auto;
  padding: 2rem 1rem;
}

h1 {
  margin-bottom: 0.5rem;
}

.intro {
  margin-bottom: 2rem;
  color: #4b5563;
  font-size: 0.95rem;
}

.login-form {
  display: flex;
  flex-direction: column;
  gap: 1.2rem;
}

label {
  display: flex;
  flex-direction: column;
  font-size: 0.9rem;
  gap: 0.3rem;
}

input {
  padding: 0.6rem;
  font-size: 1rem;
  border: 1px solid #d1d5db;
  border-radius: 4px;
}

input:focus {
  outline: none;
  border-color: #2563eb;
}

.error {
  color: #dc2626;
  font-size: 0.9rem;
}

.hint {
  margin-top: 1.5rem;
  font-size: 0.8rem;
  color: #6b7280;
  text-align: center;
}
</style>
