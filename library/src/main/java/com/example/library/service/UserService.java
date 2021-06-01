package com.example.library.service;

import com.example.library.dto.LoginDTO;
import com.example.library.dto.RegisterDTO;
import com.example.library.entity.User;

public interface UserService {

    User register(RegisterDTO registerDTO);

}
