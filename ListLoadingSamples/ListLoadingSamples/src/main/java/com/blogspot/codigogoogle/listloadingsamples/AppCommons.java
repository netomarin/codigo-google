/**
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blogspot.codigogoogle.listloadingsamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by netomarin on 4/17/14.
 */
public class AppCommons {

    private AppCommons() {}

    public static ArrayList<Map<String, String>> createItemsList() {
        ArrayList<Map<String, String>> items = new ArrayList<Map<String, String>>();

        HashMap<String, String> states = new HashMap<String, String>();
        states.put("title", "AC");
        states.put("description", "Acre");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-acre.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "AL");
        states.put("description", "Alagoas");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-alagoas.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "AP");
        states.put("description", "Amapá");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-amapa.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "AM");
        states.put("description", "Amazonas");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-amazonas.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "BA");
        states.put("description", "Bahia");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-bahia.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "CE");
        states.put("description", "Ceará");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-ceara.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "DF");
        states.put("description", "Distrito Federal");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-distrito-federal.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "ES");
        states.put("description", "Espírito Santo");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-espirito-santo.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "GO");
        states.put("description", "Goiás");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-goias.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "MA");
        states.put("description", "Maranhão");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-maranhao.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "MT");
        states.put("description", "Mato Grosso");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-mato-grosso.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "MS");
        states.put("description", "Mato Grosso do Sul");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-mato-grosso-do-sul.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "MG");
        states.put("description", "Minas Gerais");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-minas-gerais.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "PA");
        states.put("description", "Pará");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-para.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "PB");
        states.put("description", "Paraíba");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-paraiba.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "PR");
        states.put("description", "Paraná");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-parana.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "PE");
        states.put("description", "Pernambuco");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-pernambuco.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "PI");
        states.put("description", "Piauí");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-piaui.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "RJ");
        states.put("description", "Rio de Janeiro");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-rio-de-janeiro.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "RN");
        states.put("description", "Rio Grande do Norte");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-tocantins.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "RS");
        states.put("description", "Rio Grande do Sul");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-rio-grande-do-sul.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "RO");
        states.put("description", "Rondônia");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-rondonia.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "RR");
        states.put("description", "Roraima");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-roraima.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "SC");
        states.put("description", "Santa Catarina");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-santa-catarina.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "SP");
        states.put("description", "São Paulo");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-sao-paulo.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "SE");
        states.put("description", "Sergipe");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-sergipe.png");
        items.add(states);

        states = new HashMap<String, String>();
        states.put("title", "TO");
        states.put("description", "Tocantins");
        states.put("flag", "http://www.estadosecapitaisdobrasil.com/imagens/bandeiras/estados/pequeno/bandeira-tocantins.png");
        items.add(states);

        return items;
    }
}