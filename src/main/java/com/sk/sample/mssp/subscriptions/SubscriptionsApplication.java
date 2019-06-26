package com.sk.sample.mssp.subscriptions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sk.sample.mssp.subscriptions.domain.model.Subscriptions;
import com.sk.sample.mssp.subscriptions.domain.repository.SubscriptionsRepository;

@SpringBootApplication
public class SubscriptionsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SubscriptionsApplication.class, args);
	}

	@Bean
	public CommandLineRunner execSampleCode(SubscriptionsRepository subscriptionsRepository) {
		return (args) -> {
			insertSubscriptions(subscriptionsRepository);
			displaySubscriptions(subscriptionsRepository);

			//executeExample1(subscriptionsRepository);
		};
	}

	public void insertSubscriptions(SubscriptionsRepository subscriptionsRepository) {

		Subscriptions subscriptions1 = new Subscriptions("Netflix구독", 1L, "abc1234");
		subscriptionsRepository.save(subscriptions1);

		Subscriptions subscriptions2 = new Subscriptions("Netflix구독", 2L, "123qwer");
		subscriptionsRepository.save(subscriptions2);

	}

	public void displaySubscriptions(SubscriptionsRepository subscriptionsRepository) {
		System.out.println("***************************************************************");

		Iterable<Subscriptions> subscriptionsList = subscriptionsRepository.findAll();
		for (Subscriptions subscriptions : subscriptionsList) {
			System.out.println(subscriptions.toString());
		}

		System.out.println("***************************************************************");
	}

	/*public void executeExample1(SubscriptionsRepository subscriptionsRepository) {
		Subscriptions subscriptions = subscriptionsRepository.findByPartyId(1L);

		subscriptionsRepository.save(subscriptions);

		displaySubscriptions(subscriptionsRepository);
	}

	public void executeExample2(SubscriptionsRepository subscriptionsRepository) {
		List<Subscriptions> subscriptions = subscriptionsRepository.findByAddressZipCode(12345);
		System.out.println("Result: " + subscriptions.toString());
	}

	public void executeExample3(SubscriptionsRepository subscriptionsRepository) {
		List<Subscriptions> subscriptions = subscriptionsRepository.findByAddressHomeAddressLike("성남");
		System.out.println("Result: " + subscriptions.toString());
	}

	public void executeExample4(SubscriptionsRepository subscriptionsRepository) {
		QSubscriptions.payment.name.like("강%");
		Subscriptions subscriptions = subscriptionsRepository.findOne(QSubscriptions.payment.email.eq("hong@sk.com"));

		subscriptions.setAddress(Address.builder().zipCode(10000).homeAddress("경기도 성남시").build());
		subscriptionsRepository.save(subscriptions);

		displaySubscriptions(subscriptionsRepository);
	}

	public void executeExample5(SubscriptionsRepository subscriptionsRepository) {
		List<Subscriptions> subscriptions = subscriptionsRepository
				.findAll(QSubscriptions.payment.address.zipCode.eq(12345));
		System.out.println("Result: " + subscriptions.toString());
	}

	public void executeExample6(SubscriptionsRepository subscriptionsRepository) {
		List<Subscriptions> subscriptions = subscriptionsRepository
				.findAll(QSubscriptions.payment.address.homeAddress.like("성남"));
		System.out.println("Result: " + subscriptions.toString());
	}

	public void executeExample7(SubscriptionsRepository subscriptionsRepository) {
		Predicate predicate = QSubscriptions.payment.memberType.eq(MemberType.BUYER)
				.and(QSubscriptions.payment.membershipLevelType.eq(MembershipLevelType.VIP));
		List<Subscriptions> subscriptions = subscriptionsRepository.findAll(predicate);
		System.out.println("Result: " + subscriptions.toString());
	}*/

	/*
	 * @Bean public CommandLineRunner
	 * execSampleCode2(@Qualifier("subscriptionsLogic") AccountService
	 * subscriptionsService) { return (args) -> { Account subscriptions = new
	 * Account("iu@sk.com", "아이유", MemberType.BUYER, MembershipLevelType.VIP);
	 * subscriptionsService.register(subscriptions);
	 * 
	 * Account result = subscriptionsService.findByEmail("iu@sk.com");
	 * System.out.println("Component API Result - " + result);
	 * 
	 * result.setAddress(new Address(11111, "서울시 영등포구"));
	 * subscriptionsService.update(result.getId(), result);
	 * 
	 * Account result2 = subscriptionsService.findByEmail("iu@sk.com");
	 * System.out.println("Component API Result2 - " + result2); }; }
	 */
}
