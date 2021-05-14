package ru.mephi.reqsystem.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Enum для перечисления ролей, доступных в системе.
 * Разграничение ролей:
 *    - ПОЛЬЗОВАТЕЛЬ ("USER")
 *    - АДМИНИСТРАТОР ("ADMIN", расширенные права)
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
