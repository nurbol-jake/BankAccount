 void main(String[] args) {
    PersonalAccount account = new PersonalAccount(1001, "Иван Петров");

    account.deposit(500);

    account.withdraw(200);

    account.add(100).add(50);
    account.subtract(75).subtract(25);

    try {
      account.withdraw(10000);
    } catch (IllegalArgumentException e) {
      System.out.println("Поймали ошибку: " + e.getMessage());
    }

    try {
      account.add(-30);
    } catch (IllegalArgumentException e) {
      System.out.println("Поймали ошибку: " + e.getMessage());
    }

    System.out.println();

    account.printTransactionHistory();

    System.out.println();

    System.out.println("Баланс: " + account.getBalance());

    System.out.println(account);

    System.out.println();

    PersonalAccount second = new PersonalAccount(1002, "Анна Смирнова");
    second.add(1000).subtract(250.5);
    System.out.println(second);
  }