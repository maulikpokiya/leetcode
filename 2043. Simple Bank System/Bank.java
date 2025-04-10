class Bank {

    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    private boolean isValid(int account) {
        return account > 0 && account <= balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(isValid(account1) && isValid(account2) && balance[account1-1] >= money) {
            balance[account1-1] -= money;
            balance[account2-1] += money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(isValid(account)) {
            balance[account-1] += money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(isValid(account) && balance[account-1] >= money) {
            balance[account-1] -= money;
            return true;
        }
        return false;
    }
}
