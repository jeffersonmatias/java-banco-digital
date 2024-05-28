public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso no valor de R$" + valor);
            System.out.println("Saldo atual:" + saldo);
        } else {
            System.out.println("Saldo insuficiente! Não foi possivel realizar o saque.");
        }
    }

    @Override
    public void depositar(double valor) {

        saldo += valor;
        System.out.println("Deposito realizado com sucesso no valor de R$" + valor);

        imprimirInfos();
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo) {
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println("Transferencia realizada com sucesso no valor de R$" + valor + " para " + contaDestino.cliente.getName());
            System.out.println("Saldo atual:" + saldo);
        } else {
            System.out.println("Saldo insuficiente! Transferencia não realizada.");
        }
    }

    protected void imprimirInfos() {
        System.out.println(String.format("Titular: %s", this.cliente.getName()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f\"", this.saldo));
    }
}
