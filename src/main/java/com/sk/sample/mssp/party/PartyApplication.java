package com.sk.sample.mssp.party;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.core.types.Predicate;
import com.sk.sample.mssp.party.domain.model.MemberType;
import com.sk.sample.mssp.party.domain.model.MembershipLevelType;
import com.sk.sample.mssp.party.domain.model.Party;
import com.sk.sample.mssp.party.domain.model.QParty;
import com.sk.sample.mssp.party.domain.repository.PartyRepository;
import com.sk.sample.mssp.shared.domain.Address;

@SpringBootApplication
public class PartyApplication {
	public static void main(String[] args) {
		SpringApplication.run(PartyApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(PartyRepository accountRepository) {	
		return (args) -> {
			insertAccounts(accountRepository);
			displayAccounts(accountRepository);
			
			executeExample1(accountRepository);
		};
	}
		
	public void insertAccounts(PartyRepository accountRepository) {
		
		Party account1 = new Party("hong@sk.com", "홍길동", MemberType.BUYER);
		accountRepository.save(account1);
		
		Party account2 = new Party("kang@sk.com", "강호동", MemberType.BUYER, MembershipLevelType.VIP);
		account2.setAddress(new Address(12345, "서울시 강남구"));
		accountRepository.save(account2);
		
		Party account3 = new Party("yu@gmail.com", "유재석", MemberType.SELLER);
		account3.setAddress(new Address(10000, "경기도 성남시"));
		accountRepository.save(account3);
		
		Party account4 = new Party("shin@sk.com", "신동엽", MemberType.BUYER, MembershipLevelType.GOLD);
		account4.setAddress(new Address(12345, "서울시 강남구"));
		accountRepository.save(account4);
	}
	
	public void displayAccounts(PartyRepository accountRepository) {
		System.out.println("***************************************************************");
		
		Iterable<Party> accountList = accountRepository.findAll();
		for(Party account : accountList) {
			System.out.println(account.toString());	
		}
		
		System.out.println("***************************************************************");
	}
	
	
	public void executeExample1(PartyRepository accountRepository) {
		Party account = accountRepository.findByEmail("hong@sk.com");
		
		account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		accountRepository.save(account);
		
		displayAccounts(accountRepository);
	}
	
	public void executeExample2(PartyRepository accountRepository) {
		List<Party> account = accountRepository.findByAddressZipCode(12345);
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample3(PartyRepository accountRepository) {
		List<Party> account = accountRepository.findByAddressHomeAddressLike("성남");
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample4(PartyRepository accountRepository) {
		QParty.party.name.like("강%");
		Party account = accountRepository.findOne(QParty.party.email.eq("hong@sk.com"));
		
		account.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		accountRepository.save(account);
		
		displayAccounts(accountRepository);
	}
	
	public void executeExample5(PartyRepository accountRepository) {
		List<Party> account = accountRepository.findAll(QParty.party.address.zipCode.eq(12345));
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample6(PartyRepository accountRepository) {
		List<Party> account = accountRepository.findAll(QParty.party.address.homeAddress.like("성남"));
		System.out.println("Result: " + account.toString());
	}
	
	public void executeExample7(PartyRepository accountRepository) {
		Predicate predicate = QParty.party.memberType.eq(MemberType.BUYER).and(
				              QParty.party.membershipLevelType.eq(MembershipLevelType.VIP));
		List<Party> account = accountRepository.findAll(predicate);
		System.out.println("Result: " + account.toString());
	}
	
	/*
	@Bean
	public CommandLineRunner execSampleCode2(@Qualifier("accountLogic") AccountService accountService) {
		return (args) -> {
			Account account = new Account("iu@sk.com", "아이유", MemberType.BUYER, MembershipLevelType.VIP);
			accountService.register(account);
			
			Account result = accountService.findByEmail("iu@sk.com");
			System.out.println("Component API Result - " + result);
			
			result.setAddress(new Address(11111, "서울시 영등포구"));
			accountService.update(result.getId(), result);
			
			Account result2 = accountService.findByEmail("iu@sk.com");
			System.out.println("Component API Result2 - " + result2);
		};
	}
	*/
}
