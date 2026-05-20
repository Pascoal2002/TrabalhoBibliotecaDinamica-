
    package ao.universidade.poo.biblioteca;

import java.util.ArrayList;
import java.util.List;

    public class Aluno {

        private String nome;
        private String matricula;

        private List<Livro> emprestimos = new ArrayList<>();

        public Aluno(String nome, String matricula) {

            this.nome = nome;
            this.matricula = matricula;
        }

        public String getNome() {
            return nome;
        }

        public String getMatricula() {
            return matricula;
        }

        public boolean matricularLivro(Livro livro) {

            if (livro.emprestar()) {

                emprestimos.add(livro);
                return true;
            }

            return false;
        }

        public boolean devolverLivro(Livro livro) {

            if (emprestimos.remove(livro)) {

                livro.devolver();
                return true;
            }

            return false;
        }

        public void mostrarEmprestimos() {

            if (emprestimos.isEmpty()) {

                System.out.println("Nenhum livro emprestado.");
                return;
            }

            for (Livro livro : emprestimos) {

                System.out.println(livro.info());
            }
        }

        @Override
        public String toString() {

            return nome + " | Matrícula: " + matricula;
        }
    }

