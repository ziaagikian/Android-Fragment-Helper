/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements. See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.ziaagikian.personal.helpers;

/**
 * @author Engr. Ziaa <https://github.com/ziaagikian>
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import org.ziaagikian.personal.R;


public class FragmentHelper {
/**
 * <p> Attach new Fragment to Activity.</p>
 * @param context
 * @param fragment
 */
	public static void attachFragment(Activity context, Fragment fragment) {
		FragmentTransaction ft = context.getSupportFragmentManager()
				.beginTransaction();
		 ft.add(R.id.fragment_container, fragment).commit();
	}
	
	/**
	 * <p>Open new fragment to existing fragment. Provides developer to add this fragment to backstack.</p>
	 * @param context
	 * @param fragment
	 * @param canAddBackStrace
	 */

	public static void openNewFragment(Activity context, Fragment fragment,
			boolean canAddBackStrace) {
		FragmentTransaction ft = context.getSupportFragmentManager()
				.beginTransaction();
		ft.setCustomAnimations(android.R.anim.slide_in_left, 0);
		ft.replace(R.id.fragment_container, fragment);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		if (canAddBackStrace) {
			ft.addToBackStack(null);
		}
		ft.commit();
	}
/**
 * <p>Close the number of fragments.</p> 
 * @param context
 * @param numBackStack
 */
	public static void popBackStack(Activity context,int numBackStack) {
		FragmentManager manager = context.getSupportFragmentManager();
		int fragCount = manager.getBackStackEntryCount();
		for(int i = fragCount; i < fragCount-numBackStack; i++){
			manager.popBackStack();
		}
	}
}
