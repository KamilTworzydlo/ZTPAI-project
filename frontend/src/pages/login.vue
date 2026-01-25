<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

const email = ref("");
const password = ref("");
const error = ref(null);
const loading = ref(false);

async function submit() {
  error.value = null;
  loading.value = true;

  if (!email.value || !password.value) {
    error.value = "Uzupełnij login oraz hasło.";
    loading.value = false;
    return;
  }

  try {
    const res = await fetch("http://localhost:8080/api/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username: email.value,
        password: password.value,
      }),
    });

    if (!res.ok) {
      throw new Error("Nieprawidłowe dane logowania");
    }

    const data = await res.json();

    // zapis JWT
    localStorage.setItem("token", data.token);
    localStorage.setItem("username", data.username);

    // przekierowanie po loginie
    router.push("/products");

  } catch (e) {
    error.value = e.message;
  } finally {
    loading.value = false;
  }
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
        Login
        <input
          type="text"
          v-model="email"
          placeholder="admin"
        />
      </label>

      <label>
        Hasło
        <input
          type="password"
          v-model="password"
          placeholder="admin"
        />
      </label>

      <p v-if="error" class="error">{{ error }}</p>

      <button class="btn btn-primary" :disabled="loading">
        {{ loading ? "Logowanie..." : "Zaloguj się" }}
      </button>
    </form>
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
