package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet extends Animator {
    private ValueAnimator mDelayAnim;
    private long mDuration;
    private boolean mNeedsSort;
    private HashMap<Animator, Node> mNodeMap;
    private ArrayList<Node> mNodes;
    private ArrayList<Animator> mPlayingSet;
    private AnimatorSetListener mSetListener;
    private ArrayList<Node> mSortedNodes;
    private long mStartDelay;
    private boolean mStarted;
    boolean mTerminated;

    /* renamed from: com.nineoldandroids.animation.AnimatorSet.1 */
    class C10731 extends AnimatorListenerAdapter {
        boolean canceled;
        final /* synthetic */ ArrayList val$nodesToStart;

        C10731(ArrayList arrayList) {
            this.val$nodesToStart = arrayList;
            this.canceled = false;
        }

        public void onAnimationCancel(Animator animator) {
            this.canceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.canceled) {
                int size = this.val$nodesToStart.size();
                for (int i = 0; i < size; i++) {
                    Node node = (Node) this.val$nodesToStart.get(i);
                    node.animation.start();
                    AnimatorSet.this.mPlayingSet.add(node.animation);
                }
            }
        }
    }

    class AnimatorSetListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;

        AnimatorSetListener(AnimatorSet animatorSet) {
            this.mAnimatorSet = animatorSet;
        }

        public void onAnimationCancel(Animator animator) {
            if (!AnimatorSet.this.mTerminated && AnimatorSet.this.mPlayingSet.size() == 0 && AnimatorSet.this.mListeners != null) {
                int size = AnimatorSet.this.mListeners.size();
                for (int i = 0; i < size; i++) {
                    ((AnimatorListener) AnimatorSet.this.mListeners.get(i)).onAnimationCancel(this.mAnimatorSet);
                }
            }
        }

        public void onAnimationEnd(Animator animator) {
            animator.removeListener(this);
            AnimatorSet.this.mPlayingSet.remove(animator);
            ((Node) this.mAnimatorSet.mNodeMap.get(animator)).done = true;
            if (!AnimatorSet.this.mTerminated) {
                int i;
                boolean z;
                ArrayList access$200 = this.mAnimatorSet.mSortedNodes;
                int size = access$200.size();
                for (i = 0; i < size; i++) {
                    if (!((Node) access$200.get(i)).done) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    if (AnimatorSet.this.mListeners != null) {
                        ArrayList arrayList = (ArrayList) AnimatorSet.this.mListeners.clone();
                        int size2 = arrayList.size();
                        for (i = 0; i < size2; i++) {
                            ((AnimatorListener) arrayList.get(i)).onAnimationEnd(this.mAnimatorSet);
                        }
                    }
                    this.mAnimatorSet.mStarted = false;
                }
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class Builder {
        private Node mCurrentNode;

        Builder(Animator animator) {
            this.mCurrentNode = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (this.mCurrentNode == null) {
                this.mCurrentNode = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, this.mCurrentNode);
                AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }

        public Builder after(long j) {
            Animator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j);
            after(ofFloat);
            return this;
        }

        public Builder after(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            this.mCurrentNode.addDependency(new Dependency(node, 1));
            return this;
        }

        public Builder before(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 1));
            return this;
        }

        public Builder with(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 0));
            return this;
        }
    }

    class Dependency {
        static final int AFTER = 1;
        static final int WITH = 0;
        public Node node;
        public int rule;

        public Dependency(Node node, int i) {
            this.node = node;
            this.rule = i;
        }
    }

    class DependencyListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        public DependencyListener(AnimatorSet animatorSet, Node node, int i) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = i;
        }

        private void startIfReady(Animator animator) {
            if (!this.mAnimatorSet.mTerminated) {
                Object obj;
                int size = this.mNode.tmpDependencies.size();
                for (int i = 0; i < size; i++) {
                    obj = (Dependency) this.mNode.tmpDependencies.get(i);
                    if (obj.rule == this.mRule && obj.node.animation == animator) {
                        animator.removeListener(this);
                        break;
                    }
                }
                obj = null;
                this.mNode.tmpDependencies.remove(obj);
                if (this.mNode.tmpDependencies.size() == 0) {
                    this.mNode.animation.start();
                    this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
                }
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.mRule == 1) {
                startIfReady(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            if (this.mRule == 0) {
                startIfReady(animator);
            }
        }
    }

    class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies;
        public boolean done;
        public ArrayList<Node> nodeDependencies;
        public ArrayList<Node> nodeDependents;
        public ArrayList<Dependency> tmpDependencies;

        public Node(Animator animator) {
            this.dependencies = null;
            this.tmpDependencies = null;
            this.nodeDependencies = null;
            this.nodeDependents = null;
            this.done = false;
            this.animation = animator;
        }

        public void addDependency(Dependency dependency) {
            if (this.dependencies == null) {
                this.dependencies = new ArrayList();
                this.nodeDependencies = new ArrayList();
            }
            this.dependencies.add(dependency);
            if (!this.nodeDependencies.contains(dependency.node)) {
                this.nodeDependencies.add(dependency.node);
            }
            Node node = dependency.node;
            if (node.nodeDependents == null) {
                node.nodeDependents = new ArrayList();
            }
            node.nodeDependents.add(this);
        }

        public Node clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = this.animation.clone();
                return node;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    public AnimatorSet() {
        this.mPlayingSet = new ArrayList();
        this.mNodeMap = new HashMap();
        this.mNodes = new ArrayList();
        this.mSortedNodes = new ArrayList();
        this.mNeedsSort = true;
        this.mSetListener = null;
        this.mTerminated = false;
        this.mStarted = false;
        this.mStartDelay = 0;
        this.mDelayAnim = null;
        this.mDuration = -1;
    }

    private void sortNodes() {
        int size;
        Node node;
        int i;
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            ArrayList arrayList = new ArrayList();
            size = this.mNodes.size();
            for (int i2 = 0; i2 < size; i2++) {
                node = (Node) this.mNodes.get(i2);
                if (node.dependencies == null || node.dependencies.size() == 0) {
                    arrayList.add(node);
                }
            }
            Object arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (i = 0; i < size2; i++) {
                    node = (Node) arrayList.get(i);
                    this.mSortedNodes.add(node);
                    if (node.nodeDependents != null) {
                        int size3 = node.nodeDependents.size();
                        for (size = 0; size < size3; size++) {
                            Node node2 = (Node) node.nodeDependents.get(size);
                            node2.nodeDependencies.remove(node);
                            if (node2.nodeDependencies.size() == 0) {
                                arrayList2.add(node2);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.mNodes.size();
        for (i = 0; i < size4; i++) {
            node = (Node) this.mNodes.get(i);
            if (node.dependencies != null && node.dependencies.size() > 0) {
                int size5 = node.dependencies.size();
                for (size = 0; size < size5; size++) {
                    Dependency dependency = (Dependency) node.dependencies.get(size);
                    if (node.nodeDependencies == null) {
                        node.nodeDependencies = new ArrayList();
                    }
                    if (!node.nodeDependencies.contains(dependency.node)) {
                        node.nodeDependencies.add(dependency.node);
                    }
                }
            }
            node.done = false;
        }
    }

    public void cancel() {
        this.mTerminated = true;
        if (isStarted()) {
            Iterator it;
            ArrayList arrayList;
            if (this.mListeners != null) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((AnimatorListener) it.next()).onAnimationCancel(this);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (this.mDelayAnim != null && this.mDelayAnim.isRunning()) {
                this.mDelayAnim.cancel();
            } else if (this.mSortedNodes.size() > 0) {
                it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    ((Node) it.next()).animation.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((AnimatorListener) it2.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public AnimatorSet clone() {
        AnimatorSet animatorSet = (AnimatorSet) super.clone();
        animatorSet.mNeedsSort = true;
        animatorSet.mTerminated = false;
        animatorSet.mStarted = false;
        animatorSet.mPlayingSet = new ArrayList();
        animatorSet.mNodeMap = new HashMap();
        animatorSet.mNodes = new ArrayList();
        animatorSet.mSortedNodes = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            Node node = (Node) it.next();
            Node clone = node.clone();
            hashMap.put(node, clone);
            animatorSet.mNodes.add(clone);
            animatorSet.mNodeMap.put(clone.animation, clone);
            clone.dependencies = null;
            clone.tmpDependencies = null;
            clone.nodeDependents = null;
            clone.nodeDependencies = null;
            ArrayList listeners = clone.animation.getListeners();
            if (listeners != null) {
                Iterator it2 = listeners.iterator();
                ArrayList arrayList = null;
                while (it2.hasNext()) {
                    AnimatorListener animatorListener = (AnimatorListener) it2.next();
                    if (animatorListener instanceof AnimatorSetListener) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorListener);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        listeners.remove((AnimatorListener) it3.next());
                    }
                }
            }
        }
        it = this.mNodes.iterator();
        while (it.hasNext()) {
            node = (Node) it.next();
            clone = (Node) hashMap.get(node);
            if (node.dependencies != null) {
                Iterator it4 = node.dependencies.iterator();
                while (it4.hasNext()) {
                    Dependency dependency = (Dependency) it4.next();
                    clone.addDependency(new Dependency((Node) hashMap.get(dependency.node), dependency.rule));
                }
            }
        }
        return animatorSet;
    }

    public void end() {
        this.mTerminated = true;
        if (isStarted()) {
            Iterator it;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                sortNodes();
                it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    Node node = (Node) it.next();
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSetListener(this);
                    }
                    node.animation.addListener(this.mSetListener);
                }
            }
            if (this.mDelayAnim != null) {
                this.mDelayAnim.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    ((Node) it.next()).animation.end();
                }
            }
            if (this.mListeners != null) {
                it = ((ArrayList) this.mListeners.clone()).iterator();
                while (it.hasNext()) {
                    ((AnimatorListener) it.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> arrayList = new ArrayList();
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(((Node) it.next()).animation);
        }
        return arrayList;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public boolean isRunning() {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            if (((Node) it.next()).animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public Builder play(Animator animator) {
        if (animator == null) {
            return null;
        }
        this.mNeedsSort = true;
        return new Builder(animator);
    }

    public void playSequentially(List<Animator> list) {
        if (list != null && list.size() > 0) {
            this.mNeedsSort = true;
            if (list.size() == 1) {
                play((Animator) list.get(0));
                return;
            }
            for (int i = 0; i < list.size() - 1; i++) {
                play((Animator) list.get(i)).before((Animator) list.get(i + 1));
            }
        }
    }

    public void playSequentially(Animator... animatorArr) {
        int i = 0;
        if (animatorArr != null) {
            this.mNeedsSort = true;
            if (animatorArr.length == 1) {
                play(animatorArr[0]);
                return;
            }
            while (i < animatorArr.length - 1) {
                play(animatorArr[i]).before(animatorArr[i + 1]);
                i++;
            }
        }
    }

    public void playTogether(Collection<Animator> collection) {
        if (collection != null && collection.size() > 0) {
            this.mNeedsSort = true;
            Builder builder = null;
            for (Animator animator : collection) {
                Builder play;
                if (builder == null) {
                    play = play(animator);
                } else {
                    builder.with(animator);
                    play = builder;
                }
                builder = play;
            }
        }
    }

    public void playTogether(Animator... animatorArr) {
        int i = 1;
        if (animatorArr != null) {
            this.mNeedsSort = true;
            Builder play = play(animatorArr[0]);
            while (i < animatorArr.length) {
                play.with(animatorArr[i]);
                i++;
            }
        }
    }

    public AnimatorSet setDuration(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setDuration(j);
        }
        this.mDuration = j;
        return this;
    }

    public void setInterpolator(Interpolator interpolator) {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setInterpolator(interpolator);
        }
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public void setTarget(Object obj) {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            Animator animator = ((Node) it.next()).animation;
            if (animator instanceof AnimatorSet) {
                ((AnimatorSet) animator).setTarget(obj);
            } else if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).setTarget(obj);
            }
        }
    }

    public void setupEndValues() {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setupEndValues();
        }
    }

    public void setupStartValues() {
        Iterator it = this.mNodes.iterator();
        while (it.hasNext()) {
            ((Node) it.next()).animation.setupStartValues();
        }
    }

    public void start() {
        int i;
        int i2;
        ArrayList arrayList;
        int i3 = 0;
        this.mTerminated = false;
        this.mStarted = true;
        sortNodes();
        int size = this.mSortedNodes.size();
        for (i = 0; i < size; i++) {
            Node node = (Node) this.mSortedNodes.get(i);
            Collection listeners = node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                Iterator it = new ArrayList(listeners).iterator();
                while (it.hasNext()) {
                    AnimatorListener animatorListener = (AnimatorListener) it.next();
                    if ((animatorListener instanceof DependencyListener) || (animatorListener instanceof AnimatorSetListener)) {
                        node.animation.removeListener(animatorListener);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (i2 = 0; i2 < size; i2++) {
            node = (Node) this.mSortedNodes.get(i2);
            if (this.mSetListener == null) {
                this.mSetListener = new AnimatorSetListener(this);
            }
            if (node.dependencies == null || node.dependencies.size() == 0) {
                arrayList2.add(node);
            } else {
                int size2 = node.dependencies.size();
                for (i = 0; i < size2; i++) {
                    Dependency dependency = (Dependency) node.dependencies.get(i);
                    dependency.node.animation.addListener(new DependencyListener(this, node, dependency.rule));
                }
                node.tmpDependencies = (ArrayList) node.dependencies.clone();
            }
            node.animation.addListener(this.mSetListener);
        }
        if (this.mStartDelay <= 0) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                node = (Node) it2.next();
                node.animation.start();
                this.mPlayingSet.add(node.animation);
            }
        } else {
            this.mDelayAnim = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mDelayAnim.setDuration(this.mStartDelay);
            this.mDelayAnim.addListener(new C10731(arrayList2));
            this.mDelayAnim.start();
        }
        if (this.mListeners != null) {
            arrayList = (ArrayList) this.mListeners.clone();
            i2 = arrayList.size();
            for (i = 0; i < i2; i++) {
                ((AnimatorListener) arrayList.get(i)).onAnimationStart(this);
            }
        }
        if (this.mNodes.size() == 0 && this.mStartDelay == 0) {
            this.mStarted = false;
            if (this.mListeners != null) {
                arrayList = (ArrayList) this.mListeners.clone();
                i = arrayList.size();
                while (i3 < i) {
                    ((AnimatorListener) arrayList.get(i3)).onAnimationEnd(this);
                    i3++;
                }
            }
        }
    }
}
