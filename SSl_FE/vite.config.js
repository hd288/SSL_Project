import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'
import { fileURLToPath, URL } from 'url'

export default defineConfig({
  plugins: [react()],
  
  /* Config Alias */
  resolve: {
    alias: {
      "@": path.resolve(__dirname, "./src/"),
      "@components": `${path.resolve(__dirname, "./src/components/")}`,
      "@assets": `${path.resolve(__dirname, "./src/assets/")}`,
      "@pages": `${path.resolve(__dirname, "./src/pages/")}`,
      "@services": `${path.resolve(__dirname, "./src/services/")}`,
      "@routes": `${path.resolve(__dirname, "./src/routes/")}`,
      "@utils": `${path.resolve(__dirname, "./src/utils/")}`,
      // "@slices": `${path.resolve(__dirname, "./src/stores/slices/")}`,
      // "@api": `${path.resolve(__dirname, "./src/api/")}`,
      "@store" :fileURLToPath(new URL ("./src/store/slices", import.meta.url)),
      "@api": fileURLToPath(new URL ("./src/api", import.meta.url)),
      "@js": fileURLToPath(new URL ("./src/js/common.js", import.meta.url)),
    },
  },

  /* Config Global Scss Variable */
  css: {
    preprocessorOptions: {
      scss: { additionalData: `@import "src/assets/scss/index.scss";` },
    }
  }
})

