/**
 *
 */

package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 *
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     *
     * think of what type of keys and values would best suit the requirements
     */
    
    private final Map<String,Set<U>> followerList;

    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        /*per ogni User distinto creo una lista di follower distinta*/
        this.followerList=new HashMap<>();
    }



    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    /*casistica in cui età non passata => ageUser=-1 per default */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        super(name, surname, user, -1);
        this.followerList=new HashMap<>();
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        /*List<U> listFriends = this.followerList.get(circle);*/
        /*giustamente non posso usare un Set<U> con un List<U> */
        Set<U> tempListFriendSet= this.followerList.get(circle);
        if(tempListFriendSet==null){
            /*se non esiste il gruppo di amicizia circle lo creo */
            /*Set<U> groupFriend= new HashSet<U>(); problema di visibilità */
            tempListFriendSet= new HashSet<U>();
            this.followerList.put(circle, tempListFriendSet); 
        }
        return tempListFriendSet.add(user);
        }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Set<U> tempSet= followerList.get(groupName);
        if(tempSet==null){
            return Collections.emptyList();
            /* errore, in quanto temto ri ritornare qualcosa di null 
            return new HashSet<U>(tempSet); 
            */
        }else{
        Set<U> tempSetOfNames= new HashSet<U>();
        for(U name: tempSet){
            tempSetOfNames.add(name);
        }
        return new ArrayList<>(tempSetOfNames);
        }
    }

    @Override
    public List<U> getFollowedUsers() {
        Set<U> tempSet= new HashSet<U>();
        for(Set<U> variableSet : followerList.values()){
            tempSet.addAll(variableSet);
        }return new ArrayList<U>(tempSet);
        

    }
}
