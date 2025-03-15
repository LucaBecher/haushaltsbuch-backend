package com.becher.service;

import com.becher.model.data.Transaction;
import com.becher.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // 1. Save Transaction
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // 2. Get Transaction by ID
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transactionOpt = transactionRepository.findById(id);
        return transactionOpt.orElse(null); // Returns null if not found
    }

    // 3. Get All Transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // 4. Update Transaction
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> existingTransactionOpt = transactionRepository.findById(id);
        if (existingTransactionOpt.isPresent()) {
            Transaction existingTransaction = existingTransactionOpt.get();
            existingTransaction.setDescription(transaction.getDescription());
            existingTransaction.setAmount(transaction.getAmount());
            existingTransaction.setDate(transaction.getDate());
            existingTransaction.setCategory(transaction.getCategory());
            return transactionRepository.save(existingTransaction); // Save the updated transaction
        } else {
            return null; // If transaction doesn't exist, return null
        }
    }

    // 5. Delete Transaction
    public boolean deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        } else {
            return false; // If transaction doesn't exist, return false
        }
    }

}
