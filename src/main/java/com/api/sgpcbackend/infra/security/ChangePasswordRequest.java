package com.api.sgpcbackend.infra.security;

import java.util.UUID;

public record ChangePasswordRequest (UUID id, String login, String senha_antiga, String senha_nova){}
