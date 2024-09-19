import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Despesa (abstrata)
abstract class Despesa {
    private String descricao;
    private double valor;
    private String dataVencimento;
    private boolean pago;

    public Despesa(String descricao, double valor, String dataVencimento) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.pago = false;
    }

    public void anotarPagamento(double valorPago, String dataPagamento) {
        // Lógica para anotar pagamento
        if (valorPago >= this.valor) {
            this.pago = true;
            System.out.println("Pagamento anotado em " + dataPagamento);
        } else {
            System.out.println("Valor pago é menor que o valor da despesa.");
        }
    }

    public boolean isPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + ", Valor: " + valor + ", Vencimento: " + dataVencimento + ", Pago: " + pago;
    }
}

// Classe concreta de Despesa
class DespesaConcreta extends Despesa {
    public DespesaConcreta(String descricao, double valor, String dataVencimento) {
        super(descricao, valor, dataVencimento);
    }
}

// Classe para gerenciar despesas
class DespesaManager {
    private List<Despesa> despesas = new ArrayList<>();

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public List<Despesa> listarDespesas(boolean pagas) {
        List<Despesa> resultado = new ArrayList<>();
        for (Despesa d : despesas) {
            if (d.isPago() == pagas) {
                resultado.add(d);
            }
        }
        return resultado;
    }
}

// Classe TipoDespesa
class TipoDespesa {
    private String nome;
    private static int idCounter = 0;
    private int id;

    public TipoDespesa(String nome) {
        this.nome = nome;
        this.id = idCounter++;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}

// Classe para gerenciar tipos de despesas
class TipoDespesaManager {
    private List<TipoDespesa> tipos = new ArrayList<>();

    public void adicionarTipoDespesa(TipoDespesa tipo) {
        tipos.add(tipo);
    }

    public List<TipoDespesa> listarTiposDespesa() {
        return tipos;
    }

    public void atualizarTipoDespesa(int index, TipoDespesa tipo) {
        tipos.set(index, tipo);
    }

    public void excluirTipoDespesa(int index) {
        tipos.remove(index);
    }
}

// Classe Usuario
class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }
}

// Classe para gerenciar usuários
class UsuarioManager {
    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public void atualizarUsuario(int index, Usuario usuario) {
        usuarios.set(index, usuario);
    }

    public void excluirUsuario(int index) {
        usuarios.remove(index);
    }
}

// Classe principal do sistema
public class SistemaControleDespesas {
    private DespesaManager despesaManager;
    private TipoDespesaManager tipoDespesaManager;
    private UsuarioManager usuarioManager;

    public SistemaControleDespesas() {
        despesaManager = new DespesaManager();
        tipoDespesaManager = new TipoDespesaManager();
        usuarioManager = new UsuarioManager();
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Entrar Despesa");
            System.out.println("2. Anotar Pagamento");
            System.out.println("3. Listar Despesas em Aberto");
            System.out.println("4. Listar Despesas Pagas");
            System.out.println("5. Gerenciar Tipos de Despesa");
            System.out.println("6. Gerenciar Usuários");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        adicionarDespesa(scanner);
                        break;
                    case 2:
                        anotarPagamento(scanner);
                        break;
                    case 3:
                        listarDespesas(false);
                        break;
                    case 4:
                        listarDespesas(true);
                        break;
                    case 5:
                        gerenciarTiposDespesa(scanner);
                        break;
                    case 6:
                        gerenciarUsuarios(scanner);
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine(); // Limpar buffer
            }
        } while (opcao != 7);
        scanner.close();
    }

    private void adicionarDespesa(Scanner scanner) {
        System.out.print("Descrição da despesa: ");
        String descricao = scanner.nextLine();
        System.out.print("Valor da despesa: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Data de vencimento (dd/MM/yyyy): ");
        String dataVencimento = scanner.nextLine();

        Despesa novaDespesa = new DespesaConcreta(descricao, valor, dataVencimento);
        despesaManager.adicionarDespesa(novaDespesa);
        System.out.println("Despesa adicionada.");
    }

    private void anotarPagamento(Scanner scanner) {
        System.out.print("Índice da despesa: ");
        int indexDespesa = scanner.nextInt();
        if (indexDespesa < 0 || indexDespesa >= despesaManager.listarDespesas(false).size()) {
            System.out.println("Índice inválido.");
            return;
        }

        System.out.print("Valor pago: ");
        double valorPago = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Data do pagamento (dd/MM/yyyy): ");
        String dataPagamento = scanner.nextLine();

        Despesa despesa = despesaManager.listarDespesas(false).get(indexDespesa);
        despesa.anotarPagamento(valorPago, dataPagamento);
        System.out.println("Pagamento anotado.");
    }

    private void listarDespesas(boolean pagas) {
        System.out.println(pagas ? "Despesas pagas:" : "Despesas em aberto:");
        for (Despesa d : despesaManager.listarDespesas(pagas)) {
            System.out.println(d);
        }
    }

    private void gerenciarTiposDespesa(Scanner scanner) {
        int opcao = 0;
        do {
            System.out.println("\nGerenciar Tipos de Despesa");
            System.out.println("1. Adicionar Tipo de Despesa");
            System.out.println("2. Listar Tipos de Despesa");
            System.out.println("3. Atualizar Tipo de Despesa");
            System.out.println("4. Excluir Tipo de Despesa");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do tipo de despesa: ");
                        String nomeTipo = scanner.nextLine();
                        TipoDespesa novoTipo = new TipoDespesa(nomeTipo);
                        tipoDespesaManager.adicionarTipoDespesa(novoTipo);
                        System.out.println("Tipo de despesa adicionado.");
                        break;
                    case 2:
                        System.out.println("Tipos de despesa:");
                        for (TipoDespesa t : tipoDespesaManager.listarTiposDespesa()) {
                            System.out.println("ID: " + t.getId() + ", Nome: " + t.getNome());
                        }
                        break;
                    case 3:
                        System.out.print("Índice do tipo de despesa a ser atualizado: ");
                        int indexTipo = scanner.nextInt();
                        if (indexTipo < 0 || indexTipo >= tipoDespesaManager.listarTiposDespesa().size()) {
                            System.out.println("Índice inválido.");
                            break;
                        }
                        scanner.nextLine(); // Limpar buffer
                        System.out.print("Novo nome do tipo de despesa: ");
                        String novoNomeTipo = scanner.nextLine();
                        TipoDespesa tipoAtualizado = new TipoDespesa(novoNomeTipo);
                        tipoDespesaManager.atualizarTipoDespesa(indexTipo, tipoAtualizado);
                        System.out.println("Tipo de despesa atualizado.");
