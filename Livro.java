package ao.universidade.poo.biblioteca;

    public class Livro {

        private String titulo;
        private String autor;
        private String isbn;
        private boolean disponivel = true;

        public Livro(String titulo, String autor, String isbn) {

            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public String getIsbn() {
            return isbn;
        }

        public boolean isDisponivel() {
            return disponivel;
        }

        public boolean emprestar() {

            if (!disponivel) {
                return false;
            }

            disponivel = false;
            return true;
        }

        public void devolver() {
            disponivel = true;
        }

        public String info() {

            return titulo + " - "
                    + autor
                    + " | ISBN: "
                    + isbn
                    + " | Disponível: "
                    + (disponivel ? "Sim" : "Não");
        }
    }

