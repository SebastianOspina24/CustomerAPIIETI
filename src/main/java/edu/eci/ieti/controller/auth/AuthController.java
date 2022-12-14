package edu.eci.ieti.controller.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.dto.LoginDto;
import edu.eci.ieti.dto.TokenDto;
import edu.eci.ieti.entity.Customer;
import edu.eci.ieti.exception.InvalidCredentialsException;
import edu.eci.ieti.service.CustomerService;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static edu.eci.ieti.util.Constants.CLAIMS_ROLES_KEY;
import static edu.eci.ieti.util.Constants.TOKEN_DURATION_MINUTES;

@RestController
@CrossOrigin("*")
@RequestMapping("v2/auth")
public class AuthController {

    @Value("${app.secret}")
    String secret;

    private final CustomerService customerService;

    public AuthController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto.getEmail());
        Optional<Customer> customer = customerService.findByEmail(loginDto.getEmail());
        if (customer.isPresent() && BCrypt.checkpw(loginDto.getPassword(), customer.get().getPasswordHash())) {
            return generateTokenDto(customer.get());
        } else {
            throw new InvalidCredentialsException();
        }
    }

    private String generateToken(Customer customer, Date expirationDate) {
        return Jwts.builder()
                .setSubject(customer.getId())
                .claim(CLAIMS_ROLES_KEY, customer.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private TokenDto generateTokenDto(Customer customer) {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, TOKEN_DURATION_MINUTES);
        String token = generateToken(customer, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }
}