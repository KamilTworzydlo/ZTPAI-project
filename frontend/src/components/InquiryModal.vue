<script setup>
import { ref } from "vue";

const props = defineProps({
  visible: Boolean,
  product: Object,
});

const emit = defineEmits(["close"]);

const name = ref("");
const email = ref("");
const message = ref("");

async function send() {
  await fetch("http://localhost:8080/api/contact", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({
      name: name.value,
      email: email.value,
      product: props.product.name,
      message: message.value,
    }),
  });

  emit("close");
  alert("Zapytanie wysłane!");
}
</script>

<template>
  <div v-if="visible" class="overlay">
    <div class="modal">
      <h2>Zapytanie o: {{ product.name }}</h2>

      <div class="field">
        <label>Imię</label>
        <input v-model="name" placeholder="Twoje imię" />
      </div>

      <div class="field">
        <label>Email</label>
        <input v-model="email" placeholder="twoj@email.pl" />
      </div>

      <div class="field">
        <label>Treść zapytania</label>
        <textarea
          v-model="message"
          placeholder="Napisz czego dotyczy zapytanie..."
        ></textarea>
      </div>

      <div class="actions">
        <button class="btn primary" @click="send">Wyślij</button>
        <button class="btn secondary" @click="$emit('close')">
          Anuluj
        </button>
      </div>
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
  z-index: 1000;
}

.modal {
  background: white;
  padding: 2rem;
  border-radius: 12px;
  width: 420px;
  max-width: 90%;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.25);
}

.modal h2 {
  margin-bottom: 1.5rem;
}

.field {
  display: flex;
  flex-direction: column;
  margin-bottom: 1rem;
}

.field label {
  font-size: 0.85rem;
  margin-bottom: 0.3rem;
  color: #374151;
}

.field input,
.field textarea {
  padding: 0.6rem 0.7rem;
  border-radius: 6px;
  border: 1px solid #d1d5db;
  font-size: 0.9rem;
}

.field textarea {
  min-height: 90px;
  resize: vertical;
}

.actions {
  display: flex;
  justify-content: flex-end;
  gap: 1rem;
  margin-top: 1.5rem;
}

.btn {
  padding: 0.6rem 1.2rem;
  border-radius: 6px;
  border: none;
  cursor: pointer;
  font-weight: 500;
}

.primary {
  background: #2563eb;
  color: white;
}

.primary:hover {
  background: #1d4ed8;
}

.secondary {
  background: #e5e7eb;
  color: #111827;
}

.secondary:hover {
  background: #d1d5db;
}
</style>
