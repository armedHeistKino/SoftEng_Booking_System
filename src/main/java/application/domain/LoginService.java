package application.domain;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    private Map<String, RegisteredCustomer> registeredCustomers;

    public LoginService() {
        registeredCustomers = new HashMap<>();
        // 회원 가입 시 등록된 고객 정보를 저장합니다.
        RegisteredCustomer customer1 = new RegisteredCustomer("0000-0000-0000", "현장손님", "00");
        registeredCustomers.put(customer1.getPhoneNumber(), customer1);
    }

    public boolean login(String phoneNumber, String password) {
        if (registeredCustomers.containsKey(phoneNumber)) {
            RegisteredCustomer customer = registeredCustomers.get(phoneNumber);
            if (customer.getPassword().equals(password)) {
                // 로그인 성공
                return true;
            }
        }
        // 로그인 실패
        return false;
    }
}