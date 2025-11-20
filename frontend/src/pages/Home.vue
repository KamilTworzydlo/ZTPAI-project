<template>
  <section style="max-width:1100px; margin:0 auto;">
    <div style="background:linear-gradient(90deg,#fff7f0,#f0fff7); padding:36px; border-radius:8px; text-align:center;">
      <h2>Wypożyczalnia szalunków i rusztowań</h2>
      <p>Sprawdź naszą ofertę i oblicz przybliżoną cenę wynajmu.</p>
    </div>

    <div style="display:flex; gap:16px; margin-top:24px; flex-wrap:wrap;">
      <ProductCard
        v-for="p in products"
        :key="p.id"
        :product="p"
      />
    </div>
  </section>
</template>

<script>
import ProductCard from '../components/ProductCard.vue'
import { fetchProducts } from '../api/products'

export default {
  components: { ProductCard },
  data() {
    return { products: [] }
  },
  async created() {
    try {
      this.products = await fetchProducts()
    } catch (e) {
      console.error("Błąd pobierania produktów", e)
      alert("Błąd pobierania produktów z serwera")
    }
  }
}
</script>
