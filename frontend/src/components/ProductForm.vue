<template>
  <form @submit.prevent="submit">
    <input v-model="name" placeholder="Name" required />
    <input v-model.number="price" type="number" placeholder="Price per day" required />
    <input v-model="categoryName" placeholder="Category name" required />
    <button>Add product</button>
  </form>
</template>

<script setup>
import { ref } from 'vue';
import { createProduct } from '@/api/productsApi';

const emit = defineEmits(['created']);

const name = ref('');
const price = ref(0);
const categoryName = ref('');

async function submit() {
  await createProduct({
    name: name.value,
    pricePerDay: price.value,
    categoryName: categoryName.value,
  });

  emit('created');
}
</script>
