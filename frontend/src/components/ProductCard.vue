<template>
  <div class="card">
    <div class="card-image">
      <span>Zdjęcie produktu</span>
    </div>

    <div class="card-content">
      <h3 class="card-title">{{ product.name }}</h3>
      <p class="card-description">{{ product.description }}</p>

      <div class="card-footer">
        <span class="price">{{ product.pricePerDay }} zł / dzień</span>
        <button class="btn btn-primary" @click="$emit('inquiry', product)">
          Zapytaj
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
defineProps({
  product: {
    type: Object,
    required: true,
  },
});

defineEmits(["inquiry"]);
</script>

<style scoped>
.card {
  background: #ffffff;
  border-radius: 8px;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.08);
  overflow: hidden;
  display: flex;
  flex-direction: column;
  transition: transform 0.25s ease, box-shadow 0.25s ease;
}

.card:hover {
  transform: translateY(-6px);
  box-shadow: 0 18px 35px rgba(0, 0, 0, 0.12);
}

/* IMAGE */
.card-image {
  background: #e5e7eb;
  height: 160px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #6b7280;
  font-size: 0.9rem;
}

/* CONTENT */
.card-content {
  padding: 1.2rem;
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

.card-title {
  font-size: 1.05rem;
  margin-bottom: 0.4rem;
}

.card-description {
  font-size: 0.9rem;
  color: #4b5563;
  flex-grow: 1;
}

/* FOOTER */
.card-footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 1rem;
}

.price {
  font-weight: bold;
  color: #111827;
}
</style>
