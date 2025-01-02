package com.prx.directory.api.v1.service;

import com.prx.commons.pojo.Person;
import com.prx.directory.api.v1.to.UserCreateRequest;
import com.prx.directory.api.v1.to.UserCreateResponse;
import com.prx.directory.client.BackboneClient;
import com.prx.directory.mapper.UserCreateMapper;
import com.prx.directory.client.to.BackboneUserCreateRequest;
import com.prx.directory.client.to.BackboneUserCreateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
class UserServiceImplTest {

    @Mock
    private BackboneClient backboneClient;
    @Mock
    private UserCreateMapper userCreateMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(userService, "applicationId", "123e4567-e89b-12d3-a456-426614174000");
        ReflectionTestUtils.setField(userService, "initialRoleId", "123e4567-e89b-12d3-a456-426614174001");
    }

    @Test
    @DisplayName("Create User Successfully")
    void createUserSuccessfully() {
        UserCreateRequest request = new UserCreateRequest(
                "abc123",
                "user@domain.ext",
                "John",
                "Connor",
                LocalDate.parse("1984-05-12"),
                "547424"
        );
        Person person = new Person();
        person.setGender("M");
        person.setFirstName("John");
        person.setLastName("Connor");
        person.setBirthdate(LocalDate.parse("1984-05-12"));
        person.setMiddleName("A");

        BackboneUserCreateRequest backboneRequest = new BackboneUserCreateRequest(
                UUID.randomUUID(),
                "alias",
                "password",
                "user@domain.ext",
                true,
                person,
                UUID.randomUUID(),
                UUID.randomUUID()
        );
        BackboneUserCreateResponse backboneResponse = new BackboneUserCreateResponse(
                UUID.randomUUID(),
                "alias",
                "user@domain.ext",
                LocalDateTime.now(),
                LocalDateTime.now(),
                true,
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID()
        );

        UserCreateResponse response = new UserCreateResponse(UUID.randomUUID(),
                "john1",
                "user@domain.ext",
                LocalDateTime.now(),
                LocalDateTime.now(),
                true,
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID()
        );
        when(userCreateMapper.toBackbone(any(), any(), any())).thenReturn(backboneRequest);
        when(backboneClient.post(any())).thenReturn(backboneResponse);
        when(userCreateMapper.fromBackbone(any())).thenReturn(response);

        ResponseEntity<UserCreateResponse> result = userService.create(request);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(response, result.getBody());
    }

    @Test
    @DisplayName("Create User with Null Request")
    void createUserWithNullRequest() {
        ResponseEntity<UserCreateResponse> result = userService.create(null);
        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    @DisplayName("Create User with Invalid Email")
    void createUserWithInvalidEmail() {
        UserCreateRequest request = new UserCreateRequest(
                "abc123",
                "invalid-email",
                "John",
                "Connor",
                LocalDate.parse("1984-05-12"),
                "547424"
        );
        when(userCreateMapper.fromBackbone(any())).thenThrow(new RuntimeException("Invalid email"));
        when(userCreateMapper.toBackbone(any(), any(), any())).thenThrow(new RuntimeException("Invalid email"));

        ResponseEntity<UserCreateResponse> result = userService.create(request);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
    }

    @Test
    @DisplayName("Create User with Existing Username")
    void createUserWithExistingUsername() {
        UserCreateRequest request = new UserCreateRequest(
                "abc123",
                "user@domain.ext",
                "John",
                "Connor",
                LocalDate.parse("1984-05-12"),
                "547424"
        );
        Person person = new Person();
        person.setGender("M");
        person.setFirstName("John");
        person.setLastName("Connor");
        person.setBirthdate(LocalDate.parse("1984-05-12"));
        person.setMiddleName("A");

        BackboneUserCreateRequest backboneRequest = new BackboneUserCreateRequest(
                UUID.randomUUID(),
                "alias",
                "password",
                "user@domain.ext",
                true,
                person,
                UUID.randomUUID(),
                UUID.randomUUID()
        );
        when(userCreateMapper.toBackbone(any(), any(), any())).thenReturn(backboneRequest);
        when(backboneClient.post(any())).thenThrow(new RuntimeException("Username already exists"));

        ResponseEntity<UserCreateResponse> result = userService.create(request);

        assertEquals(HttpStatus.CONFLICT, result.getStatusCode());
    }
}
