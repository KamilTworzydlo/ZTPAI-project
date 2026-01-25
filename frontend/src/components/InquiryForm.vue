<script setup>
import { ref } from "vue";

const props = defineProps({
  product: Object
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
      message: message.value,
      product: props.product.name
    })
  });

  alert("Wysłano zapytanie!");
  emit("close");
}
</script>

<template>
  <div class="modal">
    <div class="modal-box">
      <h2>Zapytanie o: {{ product.name }}</h2>

      <input v-model="name" placeholder="Imię" />
      <input v-model="email" placeholder="Email" />
      <textarea v-model="message" placeholder="Treść zapytania"></textarea>

      <div class="actions">
        <button @click="send">Wyślij</button>
        <button @click="$emit('close')">Anuluj</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.modal {
  position: fixed;
  inset: 0;
  background: rgba(0,0,0,.6);
  display: flex;
  align-items: center;
  justify-content: center;
}
.modal-box {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  width: 400px;
}
input, textarea {
  width: 100%;
  margin: .5rem 0;
}
.actions {
  display: flex;
  justify-content: flex-end;
  gap: 1rem;
}
</style>
