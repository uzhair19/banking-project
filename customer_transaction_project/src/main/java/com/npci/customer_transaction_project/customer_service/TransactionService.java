package com.npci.customer_transaction_project.customer_service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.npci.customer_transaction_project.transaction_entity.Transaction;

@Service
public interface TransactionService {
	public Transaction getTransactionsDetailsById(int transaction_Id);

	public List<Transaction> getAllTransactionDetails();

	public Transaction addTransaction(Transaction transaction) throws Exception;

}
