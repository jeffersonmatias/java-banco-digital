public class Main {
    public static void main(String[] args) {
        Cliente jefferson = new Cliente();
        Cliente venilton = new Cliente();
        jefferson.setName("Jefferson Carvalho");
        venilton.setName("Venilton falvoJr");
        Conta contaCorrente = new ContaCorrente(jefferson);
        Conta contaPoupanca = new ContaPoupanca(venilton);

        contaCorrente.depositar(150);
        contaCorrente.transferir(50, contaPoupanca);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();

        contaPoupanca.sacar(20);
    }
}
