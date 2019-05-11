package Java8Example;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author akshay Date 2019-05-06 22:39
 */
class BankAccountClasses {

  private static final String TEXT = "I am a {0} account with {1,number,#} units of {2} currency";

  public static void main(String[] args) throws Exception {

    List<BankAccount> accounts = new ArrayList<>();
    accounts.add(new SavingsAccount("USD", 3));//Savings
    accounts.add(new SavingsAccount("EUR", 2));//Savings
    accounts.add(new CheckingAccount("HUF", 100));//Checking
    accounts.add(new CheckingAccount("COP", 10000));//Checking
    accounts.add(new BrokerageAccount("GBP", 2));//Brokerage
    accounts.add(new BrokerageAccount("INR", 600));//Brokerage

    accounts.forEach(
        account -> System.out.println(
            MessageFormat.format(TEXT,
                account.getAccountType().getName(),//make this work
                account.getUnits(),//make this work
                account.getCurrency()//make this work
            )));
  }

  static class SavingsAccount extends BankAccount {

    SavingsAccount(String currency, int units) {
      super(currency, units, AccountType.SAVING);
    }

  }

  static class CheckingAccount extends BankAccount {

    CheckingAccount(String currency, int units) {
      super(currency, units, AccountType.CHECKING);
    }
  }

  static class BrokerageAccount extends BankAccount {

    BrokerageAccount(String currency,
        int units) {
      super(currency, units, AccountType.BROKERAGE);
    }
  }

  static class BankAccount {

    private String currency;
    private int units;
    private AccountType accountType;

    BankAccount(String currency, int units, AccountType accountType) {
      this.currency = currency;
      this.units = units;
      this.accountType = accountType;
    }


    String getCurrency() {
      return currency;
    }

    int getUnits() {
      return units;
    }

    AccountType getAccountType() {
      return accountType;
    }

    enum AccountType {
      SAVING("savings"),
      CHECKING("checking"),
      BROKERAGE("brokerage");

      private String name;

      AccountType(String name) {
        this.name = name;
      }

      public String getName() {
        return name;
      }
    }
  }
}
