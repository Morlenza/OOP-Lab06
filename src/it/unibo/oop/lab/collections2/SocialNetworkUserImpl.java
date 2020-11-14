package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U> Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

	/*
	 * 
	 * [FIELDS]
	 * 
	 * Define any necessary field
	 * 
	 * In order to save the people followed by a user organized in groups, adopt a
	 * generic-type Map:
	 * 
	 * think of what type of keys and values would best suit the requirements
	 */

	private final Map<String, Set<U>> map;

	/*
	 * [CONSTRUCTORS]
	 * 
	 * 1) Complete the definition of the constructor below, for building a user
	 * participating in a social network, with 4 parameters, initializing:
	 * 
	 * - firstName - lastName - username - age and every other necessary field
	 * 
	 * 2) Define a further constructor where age is defaulted to -1
	 */

	/**
	 * Builds a new {@link SocialNetworkUserImpl}.
	 * 
	 * @param name    the user firstname
	 * @param surname the user lastname
	 * @param userAge user's age
	 * @param user    alias of the user, i.e. the way a user is identified on an
	 *                application
	 */
	public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
		super(name, surname, user, userAge);
		this.map = new HashMap<>();
	}

	public SocialNetworkUserImpl(final String name, final String surname, final String user) {
		super(name, surname, user);
		this.map = new HashMap<>();
	}

	/*
	 * [METHODS]
	 * 
	 * Implements the methods below
	 */

	@Override
	public boolean addFollowedUser(final String circle, final U user) {
		if (!isIncluded(user)) {
			if (isGroupExisting(circle)) {
				this.map.get(circle).add(user);
				return true;
			} else {
				this.map.put(circle, new HashSet<U>());
				this.map.get(circle).add(user);
				return true;
			}
		}
		return false;
	}

	private boolean isGroupExisting(String circle) {
		return this.map.containsKey(circle);
	}

	private boolean isIncluded(U user) {
		boolean check = false;
		for (Set<U> set : map.values()) {
			if (set.contains(user)) {
				check = true;
			}
		}
		return check;
	}

	@Override
	public Collection<U> getFollowedUsersInGroup(final String groupName) {
		if (this.map.containsKey(groupName)) {
			return new LinkedList<U>(this.map.get(groupName));
		}
		return Collections.emptyList();
	}

	@Override
	public List<U> getFollowedUsers() {
		Set<U> listUsers = new HashSet<>();
		for (Set<U> set : map.values()) {
			listUsers.addAll(set);
		}
		return new ArrayList<>(listUsers);
	}

}
