package com.fiap.tc.templates;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.fiap.tc.adapter.repository.entity.core.UsuarioEntity;

public class LoginTemplates implements TemplateLoader {

	@Override
	public void load() {
			
		Fixture.of(UsuarioEntity.class).addTemplate("valid", new Rule() {
            {
                add("id", random(Long.class, range(1, 100)));
                add("uuid", UUID.randomUUID());
                add("login", random("myller@teste.com","dener@teste.com"));
                add("nome", random("Myller", "Dener"));
                add("email", random("myller@teste.com","dener@teste.com"));
                add("senha", RandomStringUtils.randomAlphabetic(32));
                add("senhaAes", RandomStringUtils.randomAlphabetic(32));
                
                
                
            }
        });
		
	}

}
