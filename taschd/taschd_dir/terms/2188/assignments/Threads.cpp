#include <boost/thread.hpp>
#include <iostream>

boost::mutex mutex;

void init()
{
  static bool done = false;
  //boost::lock_guard<boost::mutex> lock(mutex);
  if (!done)
  {
    done = true;
    std::cout << "done" << '\n';
  }
}

void thread()
{
  init();
  init();
}

int main()
{
  int size = 5;
  boost::thread t[size];

  for (int i = 0; i < size; ++i)
    t[i] = boost::thread(thread);

  for (int i = 0; i < 3; ++i)
    t[i].join();
}