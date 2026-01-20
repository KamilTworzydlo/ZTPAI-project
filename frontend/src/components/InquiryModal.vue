<script setup>
import { ref, watch } from "vue";

const props = defineProps({
  product: Object,
  visible: Boolean,
});

const emit = defineEmits(["close"]);

const name = ref("");
const email = ref("");
const message = ref("");
const error = ref(null);
const success = ref(false);

watch(
  () => props.product,
  (p) => {
    if (p) {
      message.value = `Zapytanie o produkt: ${p.name}`;
    }
  },
  { immediate: true }
);

function submit() {
  error.value = null;
  success.value = false;

  if (!name.value || !email.value || !message.value) {
    error.value = "Wszystkie pola są wymagane.";
    return;
  }

  if (!email.value.includes("@")) {
    error.value = "Podaj poprawny adres email.";
    return;
  }

  // MOCK wysyłki
  console.log("INQUIRY:", {
    product: props.product?.name,
    name: name.value,
    email: email.value,
    message: message.value,
  });

  success.value = true;
  name.value = "";
  email.value = "";
}
</script>

<template>
  <div v-if="visible" class="overlay">
    <div class="modal">
      <button class="close" @click="emit('close')">×</button>

      <h2>Zapytanie o produkt</h2>
      <p v-if="product"><strong>{{ product.name }}</strong></p>

      <form @submit.prevent="submit">
        <input v-model="name" placeholder="Imię i nazwisko" />
        <input v-model="email" placeholder="Email" />
        <textarea v-model="message" />

        <p v-if="error" class="error">{{ error }}</p>
        <p v-if="success" class="success">
          Zapytanie wysłane (tryb demonstracyjny)
        </p>

        <button class="btn btn-primary">Wyślij zapytanie</button>
      </form>
    </div>
  </div>
</template>

<style scoped>
.overlay {
  position: fixed;
  inset: 0;
  background: rgba(0, 0, 0, 0.55);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 200;
}

.modal {
  background: #fff;
  padding: 2rem;
  width: 100%;
  max-width: 420px;
  border-radius: 8px;
  position: relative;
}

.close {
  position: absolute;
  right: 12px;
  top: 8px;
  font-size: 1.5rem;
  background: none;
  border: none;
  cursor: pointer;
}

form {
  display: flex;
  flex-direction: column;
  gap: 0.8rem;
}

input,
textarea {
  padding: 0.6rem;
  border: 1px solid #d1d5db;
  border-radius: 4px;
}

textarea {
  min-height: 100px;
}

.error {
  color: #dc2626;
  font-size: 0.9rem;
}

.success {
  color: #16a34a;
  font-size: 0.9rem;
}
</style>
