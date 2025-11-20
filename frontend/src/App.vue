<template>
  <div>
    <header style="padding:24px; background:#fff; box-shadow:0 2px 6px rgba(0,0,0,0.06)">
      <h1 style="margin:0">WYPOŻYCZALNIA SZALUNKÓW TWORZYDŁO</h1>
      <div style="margin-top:8px">
        <a href="#" style="margin-right:12px">Kontakt</a>
        <a href="#" style="margin-right:12px">Facebook</a>
      </div>
    </header>

    <main style="padding:32px; background:#f7f6fb; min-height:80vh">
      <Home />
    </main>

    <footer style="padding:16px; text-align:center; color:#666">
      © 2025 Tworzydło — Wypożyczalnia szalunków
    </footer>
  </div>
</template>

<script>
import Home from './pages/Home.vue'
export default { components: { Home } }
</script>
