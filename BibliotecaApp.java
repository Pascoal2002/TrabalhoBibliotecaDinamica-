package ao.universidade.poo.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class BibliotecaApp {

        static List<Livro> livros = new ArrayList<>();
        static List<Aluno> alunos = new ArrayList<>();

        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

            int opcao;

            do {

                System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");

                System.out.println("1 - Cadastrar Livro");
                System.out.println("2 - Cadastrar Aluno");
                System.out.println("3 - Listar Livros");
                System.out.println("4 - Listar Alunos");
                System.out.println("5 - Emprestar Livro");
                System.out.println("6 - Devolver Livro");
                System.out.println("7 - Mostrar Empréstimos");
                System.out.println("0 - Sair");

                System.out.print("Escolha: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1:
                        cadastrarLivro();
                        break;

                    case 2:
                        cadastrarAluno();
                        break;

                    case 3:
                        listarLivros();
                        break;

                    case 4:
                        listarAlunos();
                        break;

                    case 5:
                        emprestarLivro();
                        break;

                    case 6:
                        devolverLivro();
                        break;

                    case 7:
                        mostrarEmprestimos();
                        break;

                    case 0:
                        System.out.println("Sistema encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                }

            } while (opcao != 0);
        }

        public static void cadastrarLivro() {

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            Livro livro = new Livro(titulo, autor, isbn);

            livros.add(livro);

            System.out.println("Livro cadastrado com sucesso.");
        }

        public static void cadastrarAluno() {

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            Aluno aluno = new Aluno(nome, matricula);

            alunos.add(aluno);

            System.out.println("Aluno cadastrado com sucesso.");
        }

        public static void listarLivros() {

            if (livros.isEmpty()) {

                System.out.println("Nenhum livro cadastrado.");
                return;
            }

            for (int i = 0; i < livros.size(); i++) {

                System.out.println(i + " - " + livros.get(i).info());
            }
        }

        public static void listarAlunos() {

            if (alunos.isEmpty()) {

                System.out.println("Nenhum aluno cadastrado.");
                return;
            }

            for (int i = 0; i < alunos.size(); i++) {

                System.out.println(i + " - " + alunos.get(i));
            }
        }

        public static void emprestarLivro() {

            listarAlunos();

            System.out.print("Escolha o aluno: ");
            int alunoIndex = scanner.nextInt();

            listarLivros();

            System.out.print("Escolha o livro: ");
            int livroIndex = scanner.nextInt();

            scanner.nextLine();

            Aluno aluno = alunos.get(alunoIndex);
            Livro livro = livros.get(livroIndex);

            boolean sucesso = aluno.matricularLivro(livro);

            if (sucesso) {

                System.out.println("Livro emprestado com sucesso.");
            } else {

                System.out.println("Livro indisponível.");
            }
        }

        public static void devolverLivro() {

            listarAlunos();

            System.out.print("Escolha o aluno: ");
            int alunoIndex = scanner.nextInt();

            listarLivros();

            System.out.print("Escolha o livro: ");
            int livroIndex = scanner.nextInt();

            scanner.nextLine();

            Aluno aluno = alunos.get(alunoIndex);
            Livro livro = livros.get(livroIndex);

            boolean devolvido = aluno.devolverLivro(livro);

            if (devolvido) {

                System.out.println("Livro devolvido com sucesso.");
            } else {

                System.out.println("Erro ao devolver livro.");
            }
        }

        public static void mostrarEmprestimos() {

            listarAlunos();

            System.out.print("Escolha o aluno: ");
            int alunoIndex = scanner.nextInt();

            scanner.nextLine();

            Aluno aluno = alunos.get(alunoIndex);

            System.out.println("\nLivros emprestados por " + aluno.getNome());

            aluno.mostrarEmprestimos();
        }
    }

