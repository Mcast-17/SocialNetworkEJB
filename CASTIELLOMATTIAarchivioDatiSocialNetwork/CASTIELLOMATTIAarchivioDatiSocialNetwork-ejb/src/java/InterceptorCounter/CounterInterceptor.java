/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Interceptor per il monitoraggio delle chiamate ai metodi e il controllo della professione "Studente".//
// Questa implementazione è stata aggiunta successivamente siccome non sviluppata in aula durante la prova d'esame.//

package InterceptorCounter;

import java.util.concurrent.ConcurrentHashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class CounterInterceptor {
    private static ConcurrentHashMap<String, Integer> counterMap = new ConcurrentHashMap<>();

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        counterMap.merge(ic.getMethod().getName(), 1, Integer::sum);

        System.out.println("Metodo " + ic.getMethod().getName() + " chiamato [" + counterMap.get(ic.getMethod().getName()) + "] volte!");

        Object result = ic.proceed();

        // Controllo sulla professione passata come primo parametro (String)
        if (ic.getParameters().length > 0 && ic.getParameters()[0] instanceof String) 
        {
            String professione = (String) ic.getParameters()[0];
            if ("Studente".equalsIgnoreCase(professione)) 
            {
                System.out.println("Nuovo iscritto con professione studente!");
            }
        }

        return result;
    }
}
