/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saleeh.samples.utils;

import com.saleeh.samples.R;

/**
 * Represents an Item in our application. Each item has a name, id, full size image url and
 * thumbnail url.
 */
public class Item {

    private static final String LARGE_BASE_URL = "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/large/";
    private static final String THUMB_BASE_URL = "http://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/";

    public static Item[] ITEMS = new Item[]{
            new Item("Flying in the Light", "Romain Guy", R.drawable.flying_in_the_light_large),
            new Item("Caterpillar", "Romain Guy", R.drawable.caterpiller),
            new Item("Look Me in the Eye", "Romain Guy", R.drawable.look_me_in_the_eye),
            new Item("Flamingo", "Romain Guy", R.drawable.sample2),
            new Item("Rainbow", "Romain Guy", R.drawable.rainbow),
            new Item("Over there", "Romain Guy", R.drawable.over_there),
            new Item("Jelly Fish 2", "Romain Guy", R.drawable.jelly_fish_2),
            new Item("Lone Pine Sunset", "Romain Guy", R.drawable.lone_pine_sunset),
    };

    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final String mName;
    private final String mAuthor;
    public final int image;

    Item(String name, String author, int fileName) {
        mName = name;
        mAuthor = author;
        image = fileName;
    }

    public int getId() {
        return mName.hashCode() + image;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getName() {
        return mName;
    }


}
