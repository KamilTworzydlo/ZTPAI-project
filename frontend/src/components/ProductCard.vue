<template>
  <div style="background:#fff; padding:16px; border-radius:8px; width:320px; box-shadow:0 2px 6px rgba(0,0,0,0.06)">
    <h3>{{ product.name }}</h3>
    <p style="color:#444">{{ product.description }}</p>
    <p style="font-weight:600">{{ product.pricePerDay }} PLN / dzień</p>
  </div>
</template>

<script>
export default {
  props: { product: { type: Object, required: true } }
}
</script>
