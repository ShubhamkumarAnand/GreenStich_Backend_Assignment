package auth.backend.greenstitch.controllers;

import auth.backend.greenstitch.payload.request.LoginRequest;
import auth.backend.greenstitch.payload.request.SignUpRequest;
import auth.backend.greenstitch.payload.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class authController {

    @PostMapping("/sign-up")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(new MessageResponse("User Registered Successfully"));
    }

    @PostMapping("/log-in")
    public ResponseEntity<?> loginUser(@Validated @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new MessageResponse("User Signed In Successfully"));
    }

    @PostMapping("/log-out")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok(new MessageResponse("User Logged Out Successfully"));
    }
}
